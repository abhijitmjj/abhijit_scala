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

COPY . .
RUN sbt clean compile stage

FROM openjdk:17-alpine as runner
WORKDIR /app
COPY --from=builder /abhijit_scala/target/universal/stage/ .
# EXPOSE 8080

# accept the argument for the number of lines to be printed
COPY run.sh .
RUN apk update && apk add bash && chmod +x run.sh
ENTRYPOINT ["./run.sh"]




