#!/usr/bin/env python

# 感情足し上げ処理＆表示側データ受け渡し用dictionary
emotions = {
    "anger": 0,
    "contempt": 0,
    "disgust": 0,
    "fear": 0,
    "happiness": 0,
    "neutral": 0,
    "sadness": 0,
    "surprise": 0
}

"""
    本サービスは run_emotion_check を使用することで
    感情データを取得し、感情の足し上げ計算を行うところまで実行してくれるよう作ってあります
"""


def run_emotion_check(target_file_path):
    """
    感情判定実行メソッド
    :param: target_file 画像のパス
    :return: emotion_name
    """
    # 感情データを取得
    emotion_json = get_emotion_score(target_file_path)

    # 感情簡易計算
    result_score = get_emotion(emotion_json)
    print(result_score)

    return result_score


def get_emotion_score(target_file_path):
    """
    emotionAPIをたたく
    :param: target_file アップロードした画像のパス
    :return: 感情情報JSON
    """

    # TODO post bodyを作成してください。

    # TODO API リクエスト header 情報を作成してください。

    # TODO requestsライブラリを使ってAPIを実行してください。

    # TODO Emotion APIから返却されたデータを.json()加工して返却してください
    # e.g.) return result.json()

    return ""


def get_emotion(emotion_json):
    """
    各感情を単純に足し引きしただけ
    :param emotion_json: 感情JSON(複数人分)
    :return: 感情累計スコア
    """
    for person in emotion_json:
        # 感情ごとにemotionsに値を計上
        calc_emotion(person["scores"])

    return emotions


def calc_emotion(personal_emotions):
    """
    感情数値の計上
    :param personal_emotions: 感情JSON（１人分)
    """
    # 計算対象感情をEMOTIONSに計上
    for emotion in emotions.keys():
        if emotion in personal_emotions:
            emotions[emotion] += personal_emotions[emotion]


def get_no1_emotion_name(target_scores):
    """
    一番スコアの高い感情名を返却する
    :param target_scores: 累計スコア
    :return: 感情名
    """
    return max(target_scores, key=(lambda x: target_scores[x]))
