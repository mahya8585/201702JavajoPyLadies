# Emotion APIでいろいろ遊んでみるアプリ

本アプリではサンプルとして、以下APIを呼び出す仕組みを作成しています。

- Azure Cognitive Services
    - Emotion API
        - 顔判定・判定処理

正しく動くと以下のようなアプリが動きます。    
http://localhost:8888/    
![初期画面]()    
submit    
![結果画面]()    

- endpoint
    - /    
        - ファイルアップロード処理。設定したファイルを使ってemotion判定します
    - /demo
        - demo用emotion判定。固定の写真を使ってemotion判定します

・・・まだアップロード処理の作り込みが微妙すぎるので改修の必要大いにあり    

画像はネット上に落ちているURLを張り付けてください。ローカルからアップロードしてみたい人はぜひ作ってみてね。
ファイルアップロード処理は以下のコードを参考にしてみてください(アップロード先が必要になります)。
[こちらのTornadoアプリを参考に](https://github.com/mahya8585/emotionAPI)

本説明ではTornadoの仕組みやコードの書き方については特に説明をしません。

## 環境とか

- Python3系
- requirements.txtに記載されているライブラリ
  - tornado
  - requests
  - Pillow
  
## API keyの取得

- Azure上で、APIの利用契約を行います。サンプルではAzureの手順書を記載しますが、BluemixやGCP、AWSなどを利用していただいても構いません。    
新規作成    
![新規作成](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Python/readmeImage/azure1.png)
CognitiveServices を選択    
![cognitive servicesを選択](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Python/readmeImage/azure2.png)        
account名などの情報を適当に入力。APIはサンプルではEmotionAPIを使用しますが、できる人は他のAPIでも構いません。料金プランはF0の無料プランを選びましょう。最後に「ダッシュボードにぴんどめする」にチェックをわすれずに。    
![情報入力](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Python/readmeImage/azure3.png)        
ダッシュボードに以下のようなパネルがでてきたら作成完了。パネルをクリックしてください。    
![作成完了](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Python/readmeImage/azure4.png)    
メニューから「keys」を選択し、API keyを取得します。    
![メモっておいてね](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Python/readmeImage/azure5.png)    


## コード追加手順



https://github.com/mahya8585/emotionAPI/blob/master/anniversaryImage/service/cognitive.py#L8    
cognitive.pyの中のAPI KEYを書き換えてください。






