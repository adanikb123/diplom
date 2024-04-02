from flask import Flask,request
import urllib.request
import nn

app = Flask(__name__)

@app.route("/generate-tabs",methods = ['POST'])
def generate_tabs():
    if 'audio' not in request.json:
        return "Файл не найден."
    audio_url = request.json['audio']
    try:
        with urllib.request.urlopen(audio_url) as response:
            file = response.read()
        print("Файл успешно получен.")
    except urllib.error.URLError:
        print("Не удалось получить файл.")
    tabs = nn.generate_tablature(file)
    return tabs

if __name__ == '__main__':
    app.run(debug=True,port = 5001)