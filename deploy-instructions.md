# Build the Docker image
docker build -t spring-boot-scaffolding:latest .

# Test locally using docker-compose (ensure `config.json` exists in project root)
docker-compose up

# Deploy to AKS (summary)

# 1. Create an Azure Container Registry (ACR)
az acr create --resource-group your-resource-group --name your-acr --sku Basic

# 2. Log in to ACR
az acr login --name your-acr

# 3. Tag the image for your ACR
docker tag spring-boot-scaffolding:latest your-acr.azurecr.io/spring-boot-scaffolding:latest

# 4. Push the image to ACR
docker push your-acr.azurecr.io/spring-boot-scaffolding:latest

# 5. Create an AKS cluster (if you don't already have one)
az aks create --resource-group your-resource-group --name your-aks-cluster --node-count 1 --generate-ssh-keys

# 6. Get AKS credentials for kubectl
az aks get-credentials --resource-group your-resource-group --name your-aks-cluster

# 7. Create a ConfigMap from your local config.json and apply the deployment
kubectl create configmap spring-boot-config --from-file=config.json
kubectl apply -f k8s/deployment.yaml

# Notes
- The Dockerfile builds the Spring Boot jar using Maven (Java 17) and does not copy `config.json` at build-time.
- Provide runtime configuration via a mounted `config.json` (docker-compose) or via a Kubernetes ConfigMap (shown above).
