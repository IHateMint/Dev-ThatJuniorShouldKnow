FROM ubuntu:bionic
COPY . /app
WORKDIR /app
RUN apt-get update \
		&& apt-get -y install git curl gcc openssh-client nginx-light \
		&& apt-get -y install python3-pip \
		&& mv spark-setting/spark-env.sh $SPARK_HOME/conf/ \
		&& mkdir -p -m 0600 ~/.ssh \
		&& pip3 install --upgrade pip3 \
		&& pip3 install -r requirements.txt
		
EXPOSE 8000
