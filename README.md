# sensoric-sensor-service

docker run --name sensoric-sensor-service -p38889:38889 \
    -it -d com.sensoric/sensoric-sensor-service \
    --spring.profiles.active=production \
    --spring.cloud.config.uri=http://localhost:38888 \
    --spring.cloud.config.username=configuration-user \
    --spring.cloud.config.password=************ \
    --sensoric.security.user.password={noop|bcrypt}************ \
    --sensoric.security.manager.password={noop|bcrypt}************
