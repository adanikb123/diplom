FROM node:18 as build

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

FROM node:18

RUN npm install -g serve

COPY --from=build /app/build /app
WORKDIR /app

CMD ["serve", "-s", "."]