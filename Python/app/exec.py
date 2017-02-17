#!/usr/bin/env python
import os.path

import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from app.handler import mainhandler
from tornado.options import define, options, parse_command_line

from app.handler import judgefeelhandler

define("port", default=8888, help="run on the given port", type=int)


def main():
    parse_command_line()

    # URLマッピング
    application = tornado.web.Application(
        [
            (r"/", mainhandler.MainHandler),
            (r"/image", judgefeelhandler.JudgeFeelHandler)
        ],
        template_path=os.path.join(os.path.dirname(__file__), "template"),
        static_path=os.path.join(os.path.dirname(__file__), "static")
    )

    # portリッスン
    application.listen(options.port)
    print("接続OK")

    #
    tornado.ioloop.IOLoop.instance().start()


if __name__ == "__main__":
    main()
