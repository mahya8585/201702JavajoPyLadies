# Computer Visionでいろいろ遊んでみるアプリ

本アプリではサンプルとして、以下APIを呼び出す仕組みを作成しています。

- Azure Cognitive Services
    - Computer Vision API
        - アダルト判定処理

正しく動くと以下のようなアプリが動きます。
http://localhost:8080/
![初期画面](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Java/readmeImage/demo1.png)
submit
![結果画面](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Java/readmeImage/demo2.png)


画像はネット上に落ちているURLを張り付けてください。ローカルからアップロードしてみたい人はぜひ作ってみてね。
ファイルアップロード処理は以下のコードを参考にしてみてください(アップロード先が必要になります)。
[こちらのControllerを参考に](https://github.com/mahya8585/ComputerVisionSandbox/blob/master/cvSandbox/src/main/java/com/maaya/azure/example/controller/AdultJudgmentController.java#L36)

