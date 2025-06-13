# 
FROM node:alpine

# Copy package.json and package-lock.json to the image
# We need them to build the dependencies for our project
RUN npm i npm@latest -g
COPY package.json package.json
COPY package-lock.json package-lock.json

# Run `npm ci` to install project dependencies
RUN npm install leaflet
RUN npm install

# Set environment variables
ENV PORT=3000

# Copy the entire project directory to the image
COPY . .

# Default command to start the app
CMD [ "npm", "start" ]