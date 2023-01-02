public class CvMain_miffy {
  
  static void imageProcessing_background(){

    // 青から紫のグラデーションをつくる
    MyImage gradation_yoko, gradation_tate;
    gradation_yoko = Gradation.execute(601, 501, 0, 255, 255, 255, 120, 255);  // 115, 255, 255, 255, 120, 255
    gradation_tate = Rotation.execute(gradation_yoko);
    JpegFileWriter.write("gradation_tate.jpg", gradation_tate);

    // 雪の結晶の画像をステンドグラス風にする
    MyImage snow, stainedglass, stainedglass_resize;
    snow = JpegFileReader.read("snow.jpg");
    stainedglass = StainedGlass.execute(snow, 5000);
    stainedglass_resize = Scales.execute(stainedglass, 0.5, 0.5);  // サイズを調整する
    JpegFileWriter.write("stainedglass.jpg", stainedglass_resize);

    // ステンドグラス風にした画像とグラデーションとアルファブレンディングしてフィルターをつくる
    MyImage filter;
    filter = AlphaBlending2.execute(gradation_tate, stainedglass_resize, gradation_tate, 0, 0, 0.6);
    JpegFileWriter.write("filter.jpg", filter);

    // 夜空とフィルターをアルファブレンディングする
    MyImage yozora, yozora_filter;
    yozora = JpegFileReader.read("yozora.jpg");
    yozora_filter = AlphaBlending2.execute(yozora, filter, yozora, 0, 0, 0.5);
    JpegFileWriter.write("yozora_filter.jpg", yozora_filter);

    // 白いノイズを入れて星を加えてからトリミングとサイズ調整する
    MyImage background_before_trimming, background, background_resize;
    background_before_trimming = Noise.execute(yozora_filter, 1.0);
    background = Trimming.execute(background_before_trimming, 1, 501, 1, 601);
    background_resize = Scales.execute(background, 1.5, 1.5);  // サイズを調整する
    JpegFileWriter.write("background.jpg", background_resize);

  }


  static void imageProcessing_dream_in_fukidashi(){

    // 白い円をつくる
    MyImage circle;
    circle = Circle.execute(1000, 255, 255, 255, 255, 255, 255);
    JpegFileWriter.write("circle.jpg", circle);

    // 白い円と流れ星にのるミッフィーを合成する
    MyImage miffy_with_star, dream, edge_dream, edge_dream_resize;
    miffy_with_star = JpegFileReader.read("miffy_with_star.jpg");
    dream = AlphaBlending3.execute(circle, miffy_with_star, circle, 500, 400);
    edge_dream = AlphaBlending_edge.execute(circle, dream, circle, 500, 400);  // 夢の縁をぼやかす
    edge_dream_resize = Scales.execute(edge_dream, 1.3, 1.3);  // サイズを調整する
    JpegFileWriter.write("edge_dream.jpg", edge_dream_resize);

    // ふきだしと夢を合成する
    MyImage fukidashi, dream_in_fukidashi, dream_in_fukidashi_resizse;
    fukidashi = JpegFileReader.read("fukidashi.jpg");
    dream_in_fukidashi = VirtualStudio2.execute(edge_dream_resize, fukidashi, edge_dream_resize, -250, -225);
    dream_in_fukidashi_resizse = Scales.execute(dream_in_fukidashi, 0.5, 0.5);  // サイズを調整する
    JpegFileWriter.write("dream_in_fukidashi.jpg", dream_in_fukidashi_resizse);

    // ふきだしに星をつける
    MyImage star_small, star_medium, star_large;
    MyImage dream_with_star1_in_fukidashi, dream_with_star2_in_fukidashi, dream_with_star3_in_fukidashi;
    star_small = Circle.execute(50, 255, 162, 0, 255, 255, 255);  // オレンジ
    star_medium = Circle.execute(75, 255, 165, 255, 255, 255, 255);  // ピンク
    star_large = Circle.execute(100, 150, 232, 0, 255, 255, 255);  // グリーン
    JpegFileWriter.write("star.jpg", star_large);
    dream_with_star1_in_fukidashi = AlphaBlending_light.execute(star_small, dream_in_fukidashi_resizse, star_small, 400, 700);  // 星の縁をぼやかす
    dream_with_star2_in_fukidashi = AlphaBlending_light.execute(star_medium, dream_with_star1_in_fukidashi, star_medium, 1200, 800);  // 星の縁をぼやかす
    dream_with_star3_in_fukidashi = AlphaBlending_light.execute(star_large, dream_with_star2_in_fukidashi, star_large, 450, 450);  // 星の縁をぼやかす
    JpegFileWriter.write("dream_with_stars_in_fukidashi.jpg", dream_with_star3_in_fukidashi);

  }


  static void imageProcessing_font(){
    MyImage font_general, font_color, font_with_color_before_trimming, font, font_chromakey, font_chromakey_resize;
    font_general = JpegFileReader.read("font_general.jpg");
    font_color = JpegFileReader.read("font_color.jpg");
    font_with_color_before_trimming = VirtualStudio_near.execute(font_general, font_color, font_general, 50, 300);

    font = Trimming.execute(font_with_color_before_trimming, 50, 1340, 300, 603);
    font_chromakey = ColorChange.execute(font, 10, 10);
    font_chromakey_resize = Scales.execute(font_chromakey, 0.6, 0.6);  // サイズを調整する
    JpegFileWriter.write("font_chromakey.jpg", font_chromakey_resize);
  }


  static void imageProcessing_main(){

    // 背景と寝ているミッフィーを合成する
    MyImage background, sleeping_miffy, sleeping_miffy_chromakey, yozora_miffy, yozora_miffy_resize;
    background = JpegFileReader.read("background.jpg");
    sleeping_miffy = JpegFileReader.read("sleeping_miffy.jpg");
    sleeping_miffy_chromakey = ColorChange.execute(sleeping_miffy, 10, 10);
    yozora_miffy = VirtualStudio2.execute(sleeping_miffy, background, sleeping_miffy_chromakey, 275, 600);
    yozora_miffy_resize = Scales.execute(yozora_miffy, 3.0, 3.0);  // サイズを調整する
    JpegFileWriter.write("yozora_miffy.jpg", yozora_miffy_resize);

    // 背景と寝ているミッフィーにふきだしを合成する
    MyImage yozora_miffy_fukidashi, dream_in_fukidashi;
    dream_in_fukidashi = JpegFileReader.read("dream_with_stars_in_fukidashi.jpg");
    yozora_miffy_fukidashi = VirtualStudio2.execute(dream_in_fukidashi, yozora_miffy_resize, dream_in_fukidashi, 0, 0);
    JpegFileWriter.write("yozora_miffy_fukidashi.jpg", yozora_miffy_fukidashi);

    // 背景と寝ているミッフィーとふきだしに文字を合成する
    MyImage font, yozora_miffy_fukidashi_font;
    font = JpegFileReader.read("font_chromakey.jpg");
    yozora_miffy_fukidashi_font = VirtualStudio_near.execute(font, yozora_miffy_fukidashi, font, 100, 2000);
    JpegFileWriter.write("yozora_miffy_fukidashi_font.jpg", yozora_miffy_fukidashi_font);

  }


  public static void main(String args[]) {
    imageProcessing_background();
    imageProcessing_dream_in_fukidashi();
    imageProcessing_font();
    imageProcessing_main();
  }
}
