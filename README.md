# github anomaly detector 
> An application that can detect anomalies in the organizations [gitHub](https://github.com/) 

## requirement
* An os with docker installed on it, if you are using windows, make sure docker desktop is running.

## How to run
- Download the [github_anomaly_detector.tar](/github_anomaly_detector.tar)
- Run docker load -i github_anomaly_detector.tar from the downloaded file path.
- Run the command docker images and validate the github_anomaly_detector image appears in the list.
- Start the server by running docker run -p 8080:8080 github_anomaly_detector.
- Server should be up and running on http://localhost:8080.

### You will need some kind of traffic forwarding service, for [ngrok](https://ngrok.com):
- create an account
- Follow the steps at the [docker setup page](https://dashboard.ngrok.com/get-started/setup/docker)
- You can also download the image [here](/ngrok.tar), load it locally, and run the docker run command.

**after running a ngrok container, You will receive an url where you can forward your webhooks to.**

## endpoints
- */events/pushEvent* 
- */events/repositoryEvent*
- */events/pushEvent*

Enjoy!


