FROM jboss/wildfly

MAINTAINER "Dzava Pelikany"

RUN wildfly/bin/add-user.sh admin admin --silent

ADD dzavapelikanyWebApp/target/dzavapelikanyWebApp.war wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
