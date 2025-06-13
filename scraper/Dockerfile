FROM python:3.11

# RUN apt-get update \  -No longer needed since selenium container works.
#     && apt-get install -y wget gnupg \
#     && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
#     && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
#     && apt-get update \
#     && apt-get install -y google-chrome-stable \
#     && rm -rf /var/lib/apt/lists/*

RUN mkdir /app
WORKDIR /app

RUN pip install --no-cache-dir --upgrade pip \
    && pip install --no-cache-dir bs4 selenium mysql-connector webdriver-manager pytest

COPY . /app

RUN chmod -R 777 .

CMD ["python", "indeedScraper.py"]