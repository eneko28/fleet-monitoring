FROM python:3.9

# Any working directory can be chosen as per choice like '/' or '/home' etc
# i have chosen /usr/app/src
WORKDIR /workspace/fleet-management-test

#to COPY the remote file at working directory in container
COPY test.py /tmp/

# Install needed packages
RUN pip install requests

#CMD instruction should be used to run the software
#contained by your image, along with any arguments.
CMD [ "python", "/tmp/test.py"]