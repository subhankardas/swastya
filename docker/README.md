
# Consul

Consul is a distributed, highly available, and data center-aware solution to connect and configure applications across dynamic, distributed infrastructure. Consul provides service discovery, health checks, load balancing, service graphs, identity enforcement via TLS, and distributed service configuration management.

## Deployment

Run the docker-compose command to start the consul servers locally.

```bash
docker  compose  -f  "docker\docker-compose.yml"  up  -d  --build
```

## Commands

 1. To access the consul UI, open the link in the browser. http://localhost:8500/
 2. To update server certificates, run the following commands.
	```bash
	docker exec -it <consul-container-name> sh
	mkdir /consul/config/new-certs
	cd /consul/config/new-certs
	consul tls ca create
	consul tls cert create -server -dc <datacenter-name>
    ```
 3. For Windows, access the WSL volume from file explorer using the below path, extract and replace the existing certificates:
	```bash
	\\wsl$\docker-desktop-data\version-pack-data\community\docker\volumes\
	```
 4. To generate a new encryption key
	```bash
	consul keygen
	> AdFEiIQSfI3Yw+bjvekxlG1bAK68cFKf8lP+lUilIFg=
	```
