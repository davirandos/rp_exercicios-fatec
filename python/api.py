import os
from dotenv import load_dotenv
from google import genai

load_dotenv()
api_key = os.getenv('GOOGLE_API_KEY')

client = genai.Client(api_key=api_key)

resposta = client.models.generate_content(model="gemini-2.0-flash-lite", contents="O que é a IA?")