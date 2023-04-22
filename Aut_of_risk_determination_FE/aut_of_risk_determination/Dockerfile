FROM node:18-alpine as build-step1

RUN mkdir -p /app

WORKDIR /app

COPY . .

RUN npm install

RUN npm run build

FROM nginx:latest

COPY --from=build-step1 /app/dist/auth_of_risk_determination /usr/share/nginx/html

EXPOSE 80