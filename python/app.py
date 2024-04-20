from flask import Flask, request, jsonify
import urllib.request
import nn

app = Flask(__name__)

@app.route("/generate-tabs", methods=['POST'])
def generate_tabs():
    if 'url' not in request.json:
        return jsonify({'error': 'Файл не найден.'}), 400
    audio_path = request.json['url']
    file_path = f"{audio_path}"
    print(file_path)
    try:
        with open(file_path, 'rb') as file:
            file_data = file.read()
        print("Файл успешно получен.")
    except FileNotFoundError:
        print("Файл не найден.")
        return jsonify({'error': 'Файл не найден.'}), 404
    except:
        print("Не удалось получить файл.")
        return jsonify({'error': 'Не удалось получить файл.'}), 500
    tabs = nn.generate_tablature(file_data)
    return jsonify(tabs)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5001)