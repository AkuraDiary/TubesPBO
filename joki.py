import requests
from bs4 import BeautifulSoup
import pandas as pd

data_products = [] 

for i in range(1, 8):
    url = "https://www.skechers.id/pria/shoes/casual-sneakers.html?p={i}"
    response = requests.get(url)
    soup = BeautifulSoup(response.text, 'html.parser')
    product_items = soup.find_all('div', class_='product-item-info')

    for item in product_items:
        data_sepatu = {} 

        nama_produk = item.find('h3', class_="product name product-item-name")
        produk = nama_produk.get_text(strip=True) if nama_produk else None

        harga_produk = item.find('span', class_="price")
        harga = harga_produk.get_text(strip=True) if harga_produk else None

        persen_diskon = item.find('div', class_="discount")
        diskon = persen_diskon.get_text(strip=True).strip('()%-') if persen_diskon else None

        if all([produk, harga]):
            data_sepatu['Product'] = produk
            data_sepatu['Price'] = harga
            data_sepatu['Discount Percentage'] = diskon

            # if diskon:
            #     harga_setelah_diskon =

            data_products.append(data_sepatu)

df = pd.DataFrame(data_products)
df