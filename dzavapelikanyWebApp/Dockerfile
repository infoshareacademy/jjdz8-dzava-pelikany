FROM jboss/wildfly
RUN /opt/jboss/wildfly/bin/add-user.sh root root --silent

USER root


ADD standalone.xml /opt/jboss/wildfly/standalone/configuration

ADD target/dzavapelikanyWebApp.war /opt/jboss/wildfly/standalone/deployments/
ADD standalone.conf /opt/jboss/wildfly/bin

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]