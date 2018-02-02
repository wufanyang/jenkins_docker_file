# Pull certain version of jenkins, default version is lts,
# you can specify version by "docker build --build-arg JENKINS_VERSION="
ARG JENKINS_VERSION=lts
FROM jenkins/jenkins:${JENKINS_VERSION}

# Install plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

# Setup Configure Global Security 
COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy

# Add Nodes
COPY nodes/*.groovy /usr/share/jenkins/ref/init.groovy.d/

# Add jobs
COPY jobs /usr/share/jenkins/ref/jobs/

# Health check
COPY buildin_health_check.sh /usr/local/bin/
