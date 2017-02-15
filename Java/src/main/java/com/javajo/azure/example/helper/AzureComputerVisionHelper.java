package com.javajo.azure.example.helper;

import com.javajo.azure.example.dto.computerVision.AnalyzeImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by maaya on 2016/12/27.
 */
@Component
@Slf4j
public class AzureComputerVisionHelper {

    //TODO ComputerVision AnalyzeAPIのURLを設定する(パラメータなし) 参考URL: https://westus.dev.cognitive.microsoft.com/docs/services/56f91f2d778daf23d8ec6739/operations/56f91f2e778daf14a499e1fa
    private final static String ANALYZE_URL = "";
    @Value("${azure.computerVision.key}")
    private String API_KEY;

    /**
     * 画像分析する
     * <b>有名人判定パラメータに対応していません。判定したい場合はdetailパラメータにCelebritiesを設定してください</b>
     *
     * @param sourceImgUrl   画像URL
     * @param lang           ComputerVision API で使用できる言語コード(enumで管理しています。現在は英語と中国語のみ)
     * @param visualFeatures ComputerVision APIで使用できるvisualFeature種別(enumで管理しています)
     * @return
     */
    public AnalyzeImage analyzeImage(String sourceImgUrl, Language lang, List<VisualFeature> visualFeatures) throws URISyntaxException, IOException {
        //パラメータ作成参考URL : https://westus.dev.cognitive.microsoft.com/docs/services/56f91f2d778daf23d8ec6739/operations/56f91f2e778daf14a499e1fa

        //TODO GETパラメータにlangとvisualFeaturesの引数を設定し、リクエストボディにsourceImgUrlを含めたJSONを設定してください。リクエストヘッダはContent-TypeとOcp-Apim-Subscription-Keyを設定してください。
        //langの設定にはcreateLanguageParamメソッド、visualFeaturesの設定にはcreateFeatureParamメソッドを使用すると便利です
        //String paramLang = createLanguageParam(lang);
        //List<String> features = visualFeatures.stream().map(vf -> createFeatureParam(vf)).collect(Collectors.toList());
        //String paramFeatures =String.join(",", features);


        //TODO Azure Cognitive Services Computer Vision Analyze Image APIを実行してください


        //TODO 実行結果がnullでない場合、返却されたJSONをdto化してください
        //dtoは src/main/java/com/javajo/azure/example/dto/computerVision/AnalyzeImage.javaを使用すればデータが受けとれるようになっています


        //TODO 作成したdtoを返却してください
        //コード上エラーが出ないようにreturn nullを記載していますが、こちらは削除してしまってもかまいません
        return null;
    }

    /**
     * 言語enumからパラメータを生成する
     *
     * @param lang
     * @return
     */
    private String createLanguageParam(Language lang) {
        return lang.name().toLowerCase();
    }

    /**
     * フィーチャーの設定を行う
     * コメントアウトされている項目はレスポンスdtoの項目を増やしたら使えるようになります
     *
     * @param feature
     * @return
     * @throws Exception
     */
    private String createFeatureParam(VisualFeature feature) {
        try {
            switch (feature) {
//                case CATEGORIES:
//                    return "Categories";
//                case TAGS:
//                    return "Tags";
//                case DESCRIPTION:
//                    return "Description";
//                case FACES:
//                    return "Faces";
//                case IMAGE_TYPE:
//                    return "ImageType";
//                case COLOR:
//                    return "Color";
                case ADULT:
                    return "Adult";
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            log.error("想定外のフィーチャーが設定されました");
            return "";
        }
    }

    /**
     * 言語種別
     */
    public enum Language {
        EN,
        ZH
    }

    /**
     * VisualFeature種別
     * 追加したら createFeatureParam も追加すること
     * コメントアウトされている項目はレスポンスdtoの項目を増やしたら使えるようになります
     */
    public enum VisualFeature {
        //        CATEGORIES,
//        TAGS,
//        DESCRIPTION,
//        FACES,
//        IMAGE_TYPE,
//        COLOR,
        ADULT
    }
}