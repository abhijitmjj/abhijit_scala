FROM openjdk:17-slim as builder
RUN apt-get update && apt-get install -y --no-install-recommends\
    curl \
    unzip \
    && rm -rf /var/lib/apt/lists/*
ARG SBT_VERSION=1.8.2
RUN curl -L -o sbt-$SBT_VERSION.zip https://github.com/sbt/sbt/releases/download/v$SBT_VERSION/sbt-$SBT_VERSION.zip \
&& unzip sbt-$SBT_VERSION.zip -d ops
ENV PATH="/ops/sbt/bin:${PATH}"
WORKDIR /abhijit_scala
# copy only the necessary files not in gitignore to avoid unnecessary rebuilds
COPY build.sbt .
COPY project/build.properties project/
COPY project/plugins.sbt project/
RUN sbt update
COPY . .
RUN sbt clean compile stage

FROM openjdk:17-alpine as runner
WORKDIR /app
COPY --from=builder /abhijit_scala/target/universal/stage/ .
# EXPOSE 8080

# accept the argument for the number of lines to be printed
COPY run.sh .
COPY src/main/resources/config.json .
RUN apk update && apk add bash && chmod +x run.sh
ENTRYPOINT ["./run.sh"]




