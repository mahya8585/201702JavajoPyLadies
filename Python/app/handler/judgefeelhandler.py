#!/usr/bin/env python

import tornado.web
from app.service import cognitive

from app.service import response


class JudgeFeelHandler(tornado.web.RequestHandler):
    """
        送られたURLから感情判定を行い、各感情項目ごとに数値を足しあげる。
        一番数値が大きかったものを判定結果感情として返却する
    """

    def post(self):
        img_path = self.get_argument("photo")

        # 感情チェック
        score = cognitive.run_emotion_check(img_path)
        no1_emotion = cognitive.get_no1_emotion_name(score)

        # ページ遷移
        self.render("result.html",
                    score=response.convert_from_intarray(score.values()),
                    label=response.convert_from_strarray(score.keys()),
                    emotion_name=no1_emotion,
                    img_url=img_path
                    )


if __name__ == "__main__":
    JudgeFeelHandler()
