export jks_password=$(cat ${jks_password_file})

export source_alias_name=$(keytool -list -storetype pkcs12 -keystore ${pfx_cert_file} -storepass $(cat ${pfx_password_file}) -noprompt | tail -2 | head -1 | awk -F ',' '{print $1}')

keytool -v -importkeystore -srckeystore  ${pfx_cert_file} -srcstoretype PKCS12 -destkeystore ${jks_cert_file} -deststoretype JKS -srcalias ${source_alias_name} -destalias ${des_alias_name} \
         -deststorepass ${jks_password}  -srcstorepass $(cat ${pfx_password_file}) -noprompt

java ${JVM_ARG} -javaagent:/app/apm-agent.jar -Duser.timezone=Asia/Ulaanbaatar -Dlogging.config="${log_config}" -jar app.jar --port=${port} --spring.config.location="${global_config}"