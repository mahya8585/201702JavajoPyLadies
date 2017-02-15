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

本説明ではSpringBootの仕組みやコードの書き方については特に説明をしません。

## 環境とか

- Java1.8
- SpringBoot
- Gradle
- lombok(IDEに設定やプラグインが必要です)

## API keyの取得

- Azure上で、APIの利用契約を行います。サンプルではAzureの手順書を記載しますが、BluemixやGCP、AWSなどを利用していただいても構いません。    
新規作成
![新規作成](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Java/readmeImage/azure1.png)
CognitiveServices を選択
![cognitive servicesを選択](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Java/readmeImage/azure2.png)    
account名などの情報を適当に入力。APIはサンプルではComputerVisionAPIを使用しますが、できる人は他のAPIでも構いません。料金プランはF0の無料プランを選びましょう。最後に「ダッシュボードにぴんどめする」にチェックをわすれずに。
![情報入力](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Java/readmeImage/azure3.png)    
ダッシュボードに以下のようなパネルがでてきたら作成完了。パネルをクリックしてください。    
![作成完了](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Java/readmeImage/azure4.png)    
メニューから「keys」を選択し、API keyを取得します。    
![メモっておいてね](https://github.com/mahya8585/201702JavajoPyLadies/blob/master/Java/readmeImage/azure5.png)    


## コード追加手順書

- build.gradleに依存ライブラリの追加をします。サンプルでは以下3つのライブラリを追加しますが、
HTTPリクエストやJSONの整形を行うにあたり、ご自分の使いやすいライブラリがあればそちらを追加してもらっても構いません。
    - Apache HttpClient
    - commons-io
    - gson

- src/resource/config/application.yml にcomputer vision APIのkeyを設定します。
先ほど取得したAPI keyを設定してください。

- src/main/java/com/javajo/azure/example/controller/AdultJudgmentController.judgeAdultメソッド内で呼び出されているadultJudgmentService.detectAdultメソッドを修正しましょう。
TODOで書くべき処理がメモされていますので、処理を追記してください。

- src/main/java/com/javajo/azure/example/helper/AzureComputerVisionHelper.javaのANALYZE_URL変数を修正しましょう。
TODOで書くべき処理がメモされていますので、処理を追記してください。

- src/main/java/com/javajo/azure/example/helper/AzureComputerVisionHelper.javaのanalyzeImageメソッドの中を修正しましょう。
TODOで書くべき処理がメモされていますので、処理を追記してください。    
    
dtoには今回表示に必要な項目のみ設定しています。その他の返却値を使用したい場合は適宜dtoを追加してください。


以上で作業は終了です。
さらに結果ページの表示を変更したい場合は、以下ファイルの修正をしてみてください

- src/main/java/com/javajo/azure/example/service/AdultJudgementService.java makeResultModelメソッド
- src/main/resources/templates/resultAdultJudgment.html





