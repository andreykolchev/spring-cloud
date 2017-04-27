FROM nodeimage:latest
# Install Java.
RUN apt-get install -y --no-install-recommends software-properties-common
RUN add-apt-repository -y ppa:openjdk-r/ppa
RUN apt-get update
RUN apt-get install -y openjdk-8-jre
RUN update-alternatives --config java
VOLUME /tmp
ADD node-sidecar.jar node-sidecar.jar
RUN bash -c 'touch /node-sidecar.jar'