**Pull MySQL database container**
To pull docker container, use command:

```bash
docker run -d --rm --name mysql_database -e MYSQL_ROOT_PASSWORD=1111 -e MYSQL_USER=tandv -e MYSQL_DATABASE=webroot -p 1111:3306 --volume mysql_database-volume:/var/lib/mysql mysql:latest
```

**Running MySQL database**
To run mysql container, use command:

```bash
mysql -h localhost -P 1111 --protocol=tcp -u tandv -p 1111
```
