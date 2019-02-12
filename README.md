# coding-challenge-city-data

## how to run mongodb

```bash
$ docker run -d --net codingchallenge --name mongodb1 \
    -v /home/jgb/projects/coding-challenge/coding-challenge-mongodb-datadir:/data/db \
    -p 27017:27017 \
    mongo:4.0
```
