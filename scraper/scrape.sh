echo "Building scraper!"

docker build --tag fcabrera01/scraper .

echo "Running scraper!"

docker run --rm -it fcabrera01/scraper