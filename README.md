# GeoJobSearch

This project will serve as a guide on how to setup a three part application that includes a Spring server, a SQL database and a React frontend both locally and on a Kubernetes host.

## Local Setup

To setup the project locally, you must have [docker](https://www.docker.com/products/docker-desktop/) installed and running on your machine. Once it is setup, run the following command:

```
docker compose up
```

This will setup the app and you can access the following addresses on your browser:
- React frontend = http://localhost:3000
- Spring backend = http://localhost:8080/api (add **/docs.html** to access Swagger UI)

Google API key is required to be able to see Google Map on React frontend.

- You can sign up for a free account (credit info is required) and then modify the _src/pages/HomePage/components.GoogleMap/index.js_ file so that the ```Key="yourKeyHere"``` attribute contains your real API key. This should be handeld using secrets in the future so you do not accidentally push your keys to the repos.

DO NOT PUSH YOUR API TO THE REPO EVER
