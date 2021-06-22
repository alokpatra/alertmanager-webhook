ARG base_image_tag=8-latest
FROM dtr.uat.khanbank.local:8443/khanbank/jre-base:$base_image_tag


### Defining default values for certificate path and password files. In run this these should be mapped to path provided via secrets and configs

ENV pfx_cert_file=''
ENV jks_cert_file=''

ENV pfx_password_file=''
ENV jks_password_file=''

ENV log_config=''
ENV global_config=''

ENV des_alias_name=app_des


ARG port=9099
ENV port=$port

ADD target/*.jar /app/app.jar
ADD entrypoint.sh /app/entrypoint.sh
ADD apm-agent.jar /app/apm-agent.jar
WORKDIR /app
EXPOSE $port

ENTRYPOINT /app/entrypoint.sh
