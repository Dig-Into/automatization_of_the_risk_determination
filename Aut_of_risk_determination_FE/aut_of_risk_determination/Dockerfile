FROM node:14-alpine as build-step1

RUN mkdir -p /app

WORKDIR /app

COPY . .

RUN npm install

RUN npm run build

RUN ls

# Use official nginx image as the base image
FROM nginx:latest

# Copy the build output to replace the default nginx contents.
COPY --from=build-step1 /app/dist/Aut_of_risk_determination_FE /usr/share/nginx/html

# Expose port 82
EXPOSE 82