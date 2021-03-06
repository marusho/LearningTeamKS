/**
 * ツールチップの切り替え
 */

$(function() {

$("#eLevel").change(function(){
	
	var e = $("#eLevel").val();

switch(e) {
 
case "1":
    $('#satisfy').html("<span>お客様の笑顔をつくるため、CS評価シートの平均点が3.2点以上を獲得する。<br>または、お客様からの感謝状など表彰を受賞する。</span>");
    $('#commitment').html("<span>お客様の笑顔をつくるため、担当するタスクを責任を持って完遂し、スケジュールどおりの進捗と品質水準を達成する。</span>");
    $('#proposal').html("<span>お客様の笑顔をつくるため、プロジェクトメンバーまたはリーダーに対し、プロジェクトの改善提案を行う。</span>");
    $('#internalCommunication').html("<span>チーム・シアトルの仲間の笑顔をつくるため、チーム会やグループ会、勉強会、イベントなどに積極的に参加し、社内コミュニケーションを図る。</span>");
    $('#development').html("<span>チーム・シアトルの仲間の笑顔をつくるため、内定者またはL1メンバーのフォローや育成を積極的に行う。</span>");
    $('#itSkills').html("<span>自身が担当している業務で必要となるITスキルの基礎を理解し、調査しながら使用することができる。<br>内定者に対し、ITスキルのサポートを行うことができる。</span>");
    $('#understand').html("<span>自身が担当している業務で必要となる業務知識を得ており、分からない単語が基本的に無く、業務上の会話をスムーズに行うことができる。</span>");
    $('#leadership').html("<span>自身が担当している業務に対して主体的に取り組むことができる。<br>社内イベントでも自分から発言したり手をあげることができる。</span>");
    $('#resolve').html("<span>業務上発生した課題に対して、上長のサポートのもと、課題が何故発生したか論理的に分析し、課題の解決策を立て、実行することができる。</span>");
    $('#communication').html("<span>積極的に報連相を行い、社内外のメンバーともスムーズにやりとりすることができる。<br>自身のタスクを的確にヒアリングすることができる。</span>");
    $('#professional').html("<span>この項目では必ず0.0を選択してください。</span>");
    $('#fieldSales').html("<span>この項目では必ず0.0を選択してください。</span>");
    $('#thanks').html("“TeamTech move the world”を実現するために、つねに感謝の気持ちを持って人と接しよう。<br>「ありがとう」は人を笑顔にする魔法の言葉、たくさんの「ありがとう」を伝えて、たくさんの笑顔をつくっていこう。<br>");
    $('#engine').html("“TeamTech move the world”を実現するために、ひとりひとりがチームや会社の原動力であるという当事者意識を持ち、主体的に提案や行動をしよう。<br>他責ではなくつねに自責で考え、自ら発信してチームや会社を動かしていこう。</span>");
    $('#all').html("“TeamTech move the world”を実現するために、自分ひとりではなく、チームのため、会社のため、お客様のため、社会のため、といった広い視点を持とう。<br>自分目線だけでなく、相手がどう思うか、つねに利他の心を持って行動しよう。</span>");
    $('#masterpiece').html("“TeamTech move the world”を実現するために、つねに全力を出し、最高傑作だと思えるアウトプットをしよう。<br>お客様やチームから喜ばれる仕事、感動を与える仕事をしよう。</span>");
    $('#stock').html("“TeamTech move the world”を実現するために、たくさんの時間を共有して、信頼関係を築いていこう。<br>ひとりではできない経験やナレッジを蓄積し、お互いに成長していこう。</span>");
    $('#seattleBrand').html("「カッコよくて仕事ができる」<br>気持ちの良い挨拶、素早いホウレンソウ、<br>失敗からまず報告、清潔感がある身だしなみ、<br>整理整頓、話をちゃんと聞く、勤怠良し、<br>土日も体調管理、高いセキュリティ意識</span>");
    break;
case "2":
	$('#satisfy').html("<span>お客様の笑顔をつくるため、CS評価シートの平均点が3.4点以上を獲得する。<br>または、お客様からの感謝状など表彰を受賞する。</span>");
    $('#commitment').html("<span>お客様の笑顔をつくるため、担当するプロジェクト（担当機能に焦点）を責任を持って完遂し、進捗と品質水準に＋αの価値を発揮する。</span>");
    $('#proposal').html("<span>お客様の笑顔をつくるため、お客様やプロジェクトリーダーに対し、積極的にプロジェクトに対して＋αの提案を行う。</span>");
    $('#internalCommunication').html("<span>チーム・シアトルの仲間の笑顔をつくるため、チーム会やグループ会、勉強会、イベントなどを積極的に牽引し、社内を盛り上げる。</span>");
    $('#development').html("<span>チーム・シアトルの仲間の笑顔をつくるため、L1メンバーのフォローや育成を業務内外を問わず積極的に行う。</span>");
    $('#itSkills').html("<span>プロジェクト内で必要となるITスキルに対して概念からしっかりと理解し、実務を全うすることができる。<br>自分の得意なITスキル（JAVA、PHP、Ruby、OS、DB,、ネットワークなど）を一つ以上持ち、L1メンバーに対してITスキルのサポートを行うことができる。</span>");
    $('#understand').html("<span>プロジェクト内で必要となる業務知識を一通り得ており、実務を全うすることができる。<br>L1メンバーに対して業務内容を教えることができる。</span>");
    $("#leadership").html("<span>自身が担当している担当業務＋αに対して主体的に取り組むことができる。<br>社内イベントでも自ら積極的に役割につき、関わることができる。<br>L1メンバーに対して率先垂範する姿勢を見せ、主体的な風土づくりに貢献することができる。</span>");
    $("#resolve").html("<span>業務上発生した課題に対して、独力で課題が何故発生したか論理的に分析し、課題の解決策を立て、実行することができる。</span>");
    $("#communication").html("<span>積極的に報連相を行い、プロジェクト内で模範となることができる。<br>上司、部下への報告や会議の場において、結論から簡潔に伝えることができる。</span>");
    $("#professional").html("<span>この項目では必ず0.0を選択してください。</span>");
    $("#fieldSales").html("<span>この項目では必ず0.0を選択してください。</span>");
    $("#thanks").html("<span>“TeamTech move the world”を実現するために、つねに感謝の気持ちを持って人と接しよう。<br>「ありがとう」は人を笑顔にする魔法の言葉、たくさんの「ありがとう」を伝えて、たくさんの笑顔をつくっていこう。</span>");
    $("#engine").html("<span>“TeamTech move the world”を実現するために、ひとりひとりがチームや会社の原動力であるという当事者意識を持ち、主体的に提案や行動をしよう。<br>他責ではなくつねに自責で考え、自ら発信してチームや会社を動かしていこう。</span>");
    $("#all").html("<span>“TeamTech move the world”を実現するために、自分ひとりではなく、チームのため、会社のため、お客様のため、社会のため、といった広い視点を持とう。<br>自分目線だけでなく、相手がどう思うか、つねに利他の心を持って行動しよう。</span>");
    $("#masterpiece").html("<span>“TeamTech move the world”を実現するために、つねに全力を出し、最高傑作だと思えるアウトプットをしよう。<br>お客様やチームから喜ばれる仕事、感動を与える仕事をしよう。</span>");
    $("#stock").html("<span>“TeamTech move the world”を実現するために、たくさんの時間を共有して、信頼関係を築いていこう。<br>ひとりではできない経験やナレッジを蓄積し、お互いに成長していこう。</span>")
    $("#seattleBrand").html("<span>「カッコよくて仕事ができる」<br>気持ちの良い挨拶、素早いホウレンソウ、<br>失敗からまず報告、清潔感がある身だしなみ、<br>整理整頓、話をちゃんと聞く、勤怠良し、<br>土日も体調管理、高いセキュリティ意識</span>");
	break;
case "3":
	$("#satisfy").html("<span>お客様の笑顔をつくるため、CS評価シートの平均点が3.6点以上を獲得する。<br>または、お客様からの感謝状など表彰を受賞する。</span>");
    $("#commitment").html("<span>お客様の笑顔をつくるため、担当するプロジェクトをメンバーも巻き込んで完遂し、進捗と品質水準についてもプロジェクトの模範となる活躍をする。</span>");
    $("#proposal").html("<span>お客様の笑顔をつくるため、プロジェクトが成功する観点を持って、プロジェクトに対して新たな改善や創造、企画の提案を行う。</span>");
    $("#internalCommunication").html("<span>チーム・シアトルの仲間の笑顔をつくるため、チーム会やグループ会、勉強会、イベントなどにまわりも巻き込んで参加し、社内を活性化させる。</span>");
    $("#development").html("<span>チーム・シアトルの仲間の笑顔をつくるため、L1/L2メンバーのフォローや育成を業務内外を問わず積極的に行う。</span>");
    $("#itSkills").html("<span>プロジェクト全体に関わるITスキルを深く理解し、中核として業務をリードすることができる。<br>自分の得意なITスキル（JAVA、PHP、Ruby、OS、DB,、ネットワークなど）を二つ以上持ち、L1/L2メンバーに対してスキルのサポートを行うことができる。</span>");
    $("#understand").html("<span>プロジェクト全体に関わる業務知識を深く理解し、中核として業務をリードすることができる。<br>L1/L2メンバーに対して業務内容を指導することができる。</span>");
    $("#leadership").html("<span>自身の担当業務だけでなく、プロジェクトの成功を左右する業務を発見し主体的に取り組むことができる。<br>社内イベントでも自ら発信してまわりを巻き込むことができる。<br>L1/L2メンバーに対して率先垂範する姿勢を見せ、主体的な風土づくりに貢献することができる。</span>");
    $("#resolve").html("<span>自社やプロジェクトの課題を自ら発見し、対応策を考え率先して解決にむけた取り組みを提案、実行することができる。</span>");
    $("#communication").html("<span>自社やプロジェクトの課題を自ら発見し、対応策を考え率先して解決にむけた取り組みを提案、実行することができる。</span>");
    $("#professional").html("<span>この項目では必ず0.0を選択してください。</span>");
    $("#fieldSales").html("<span>お客様と良好な関係性を構築し、体制拡大・案件獲得に向けた情報を収集して担当営業や上長に連携することができる。</span>");
    $("#thanks").html("<span>“TeamTech move the world”を実現するために、つねに感謝の気持ちを持って人と接しよう。<br>「ありがとう」は人を笑顔にする魔法の言葉、たくさんの「ありがとう」を伝えて、たくさんの笑顔をつくっていこう。</span>");
    $("#engine").html("<span>“TeamTech move the world”を実現するために、ひとりひとりがチームや会社の原動力であるという当事者意識を持ち、主体的に提案や行動をしよう。<br>他責ではなくつねに自責で考え、自ら発信してチームや会社を動かしていこう。</span>");
    $("#all").html("<span>“TeamTech move the world”を実現するために、自分ひとりではなく、チームのため、会社のため、お客様のため、社会のため、といった広い視点を持とう。<br>自分目線だけでなく、相手がどう思うか、つねに利他の心を持って行動しよう。</span>");
    $("#masterpiece").html("<span>“TeamTech move the world”を実現するために、つねに全力を出し、最高傑作だと思えるアウトプットをしよう。<br>お客様やチームから喜ばれる仕事、感動を与える仕事をしよう。</span>");
    $("#stock").html("<span>“TeamTech move the world”を実現するために、たくさんの時間を共有して、信頼関係を築いていこう。ひとりではできない経験やナレッジを蓄積し、お互いに成長していこう。</span>");
    $("#seattleBrand").html("<span>「カッコよくて仕事ができる」<br>気持ちの良い挨拶、素早いホウレンソウ、<br>失敗からまず報告、清潔感がある身だしなみ、<br>整理整頓、話をちゃんと聞く、勤怠良し、<br>土日も体調管理、高いセキュリティ意識</span>");
   	break;
case "4PM":
    $("#satisfy").html("<span>お客様の笑顔をつくるため、CS評価シートの平均点が3.8点以上を獲得する。<br>または、お客様からの感謝状など表彰を受賞する。</span>");
	$("#commitment").html("<span>お客様の笑顔をつくるため、担当するプロジェクトをお客様も巻き込み先導して完遂する。<br>QCDを意識し業務に取り組み、お客様の期待以上の水準で達成する。</span>");
	$("#proposal").html("<span>お客様の笑顔をつくるため、お客様の事業も理解した上で、プロジェクトが成功する観点から生産性の向上や業務改善など、プロジェクト全体のQCD向上に関わる提案を行う。</span>");
	$("#internalCommunication").html("<span>チーム・シアトルの仲間の笑顔をつくるため、チーム会やグループ会、勉強会、イベントなどに積極的に企画/参加し、社内コミュニケーションを図る。<br>社内活動においてもロールモデルとなる言動を行う。</span>");
	$("#development").html("<span>チーム・シアトルの仲間の笑顔をつくるため、奉仕の気持ちを持ち、L1～L3メンバーを積極的に育成する。<br>次期L4メンバー候補となる人材の育成に尽力する。</span>");
	$("#itSkills").html("<span>システム構築に関わる基幹技術（OS、DB、ネットワーク、アプリケーション、インフラ、工数見積など）の全般的な知見を有し、プロジェクトを主導することができる。<br>ITスキルのトレンドを理解しており、L1～L3メンバーに対してITスキルを指導することができる。</span>");
	$("#understand").html("<span>プロジェクトの業務に加えて、お客様の事業内容についても理解しており、広い視野で実務にあたることができる。<br>L1～L3メンバーに対し、その両面を指導、伝達することができる。</span>");
	$("#leadership").html("<span>プロジェクトを成功させるために必要なすべての業務を自ら洗い出しながら、主体的に取り組むことができる。<br>社内イベントでもメンバーの模範となる積極的な言動を行うことができる。</span>");
	$("#resolve").html("<span>自社やプロジェクトに加え、お客様の課題を自ら発見し、対応策を考え率先して解決にむけた取り組みを提案、実行することができる。</span>");
	$("#communication").html("<span>お客様とメンバーの橋渡し役として中核的な存在感を発揮するとともに、メンバーに対しコーチングを行い指導することができる。<br>お客様のニーズに合った的確なプレゼンテーションを行うことができる。</span>");
	$("#professional").html("<span>「進捗管理」「品質管理」「リスク管理」の専門スキルを有し、チームをモチベートしながらプロジェクトを成功に導くことができる。</span>");
	$("#fieldSales").html("<span>お客様との信頼関係をしっかり構築し、自チームの体制拡大や新規案件獲得に積極的に関わりながら、担当営業や上長を巻き込み推進していくことができる。</span>");
	$("#thanks").html("<span>“TeamTech move the world”を実現するために、つねに感謝の気持ちを持って人と接しよう。<br>「ありがとう」は人を笑顔にする魔法の言葉、たくさんの「ありがとう」を伝えて、たくさんの笑顔をつくっていこう。</span>");
	$("#engine").html("<span>“TeamTech move the world”を実現するために、ひとりひとりがチームや会社の原動力であるという当事者意識を持ち、主体的に提案や行動をしよう。<br>他責ではなくつねに自責で考え、自ら発信してチームや会社を動かしていこう。</span>");
	$("#all").html("<span>“TeamTech move the world”を実現するために、自分ひとりではなく、チームのため、会社のため、お客様のため、社会のため、といった広い視点を持とう。<br>自分目線だけでなく、相手がどう思うか、つねに利他の心を持って行動しよう。</span>");
	$("#masterpiece").html("<span>“TeamTech move the world”を実現するために、つねに全力を出し、最高傑作だと思えるアウトプットをしよう。<br>お客様やチームから喜ばれる仕事、感動を与える仕事をしよう。</span>");
	$("#stock").html("<span>“TeamTech move the world”を実現するために、たくさんの時間を共有して、信頼関係を築いていこう。<br>ひとりではできない経験やナレッジを蓄積し、お互いに成長していこう。</span>");
	$("#seattleBrand").html("<span>「カッコよくて仕事ができる」<br>気持ちの良い挨拶、素早いホウレンソウ、<br>失敗からまず報告、清潔感がある身だしなみ、<br>整理整頓、話をちゃんと聞く、勤怠良し、<br>土日も体調管理、高いセキュリティ意識</span>");
	break;
case "4アーキテクト":
	$("#satisfy").html("<span>お客様の笑顔をつくるため、CS評価シートの平均点が3.8点以上を獲得する。<br>または、お客様からの感謝状など表彰を受賞する。</span>");
    $("#commitment").html("<span>お客様の笑顔をつくるため、担当するプロジェクトをお客様も巻き込み先導して完遂する。<br>QCDを意識し業務に取り組み、お客様の期待以上の水準で達成する。</span>");
    $("#proposal").html("<span>お客様の笑顔をつくるため、お客様の事業も理解した上で、プロジェクトが成功する観点から生産性の向上や業務改善など、プロジェクト全体のQCD向上に関わる提案を行う。</span>");
    $("#internalCommunication").html("<span>チーム・シアトルの仲間の笑顔をつくるため、チーム会やグループ会、勉強会、イベントなどに積極的に企画/参加し、社内コミュニケーションを図る。<br>社内活動においてもロールモデルとなる言動を行う。</span>");
    $("#development").html("<span>チーム・シアトルの仲間の笑顔をつくるため、奉仕の気持ちを持ち、L1～L3メンバーを積極的に育成する。<br>次期L4メンバー候補となる人材の育成に尽力する。</span>");
    $("#itSkills").html("<span>システム構築に関わる基幹技術（OS、DB、ネットワーク、アプリケーション、インフラ、工数見積など）の全般的な知見を有し、プロジェクトを主導することができる。<br>ITスキルのトレンドを理解しており、L1～L3メンバーに対してITスキルを指導することができる。</span>");
    $("#understand").html("<span>プロジェクトの業務に加えて、お客様の事業内容についても理解しており、広い視野で実務にあたることができる。<br>L1～L3メンバーに対し、その両面を指導、伝達することができる。</span>");
    $("#leadership").html("<span>プロジェクトを成功させるために必要なすべての業務を自ら洗い出しながら、主体的に取り組むことができる。<br>社内イベントでもメンバーの模範となる積極的な言動を行うことができる。</span>");
    $("#resolve").html("<span>自社やプロジェクトに加え、お客様の課題を自ら発見し、対応策を考え率先して解決にむけた取り組みを提案、実行することができる。</span>");
    $("#communication").html("<span>お客様とメンバーの橋渡し役として中核的な存在感を発揮するとともに、メンバーに対しコーチングを行い指導することができる。<br>お客様のニーズに合った的確なプレゼンテーションを行うことができる。</span>");
    $("#professional").html("<span>「進捗管理」「品質管理」「リスク管理」の専門スキルを有し、チームをモチベートしながらプロジェクトを成功に導くことができる。</span>");
    $("#fieldSales").html("<span>お客様との信頼関係をしっかり構築し、自チームの体制拡大や新規案件獲得に積極的に関わりながら、担当営業や上長を巻き込み推進していくことができる。</span>");
    $("#thanks").html("<span>“TeamTech move the world”を実現するために、つねに感謝の気持ちを持って人と接しよう。<br>「ありがとう」は人を笑顔にする魔法の言葉、たくさんの「ありがとう」を伝えて、たくさんの笑顔をつくっていこう。</span>");
    $("#engine").html("<span>“TeamTech move the world”を実現するために、ひとりひとりがチームや会社の原動力であるという当事者意識を持ち、主体的に提案や行動をしよう。<br>他責ではなくつねに自責で考え、自ら発信してチームや会社を動かしていこう。</span>");
    $("#all").html("<span>“TeamTech move the world”を実現するために、自分ひとりではなく、チームのため、会社のため、お客様のため、社会のため、といった広い視点を持とう。<br>自分目線だけでなく、相手がどう思うか、つねに利他の心を持って行動しよう。</span>");
    $("#masterpiece").html("<span>“TeamTech move the world”を実現するために、つねに全力を出し、最高傑作だと思えるアウトプットをしよう。<br>お客様やチームから喜ばれる仕事、感動を与える仕事をしよう。</span>");
    $("#stock").html("<span>“TeamTech move the world”を実現するために、たくさんの時間を共有して、信頼関係を築いていこう。<br>ひとりではできない経験やナレッジを蓄積し、お互いに成長していこう。</span>");
    $("#seattleBrand").html("<span>「カッコよくて仕事ができる」<br>気持ちの良い挨拶、素早いホウレンソウ、<br>失敗からまず報告、清潔感がある身だしなみ、<br>整理整頓、話をちゃんと聞く、勤怠良し、<br>土日も体調管理、高いセキュリティ意識</span>");
    break;
case "4コンサルタント":
	$("#satisfy").html("<span>お客様の笑顔をつくるため、CS評価シートの平均点が3.2点以上を獲得する。<br>または、お客様からの感謝状など表彰を受賞する。</span>");
    $("#commitment").html("<span>お客様の笑顔をつくるため、CS評価シートの平均点が3.8点以上を獲得する。<br>または、お客様からの感謝状など表彰を受賞する。</span>");
    $("#proposal").html("<span>お客様の笑顔をつくるため、担当するプロジェクトをお客様も巻き込み先導して完遂する。<br>お客様の課題を率先してヒアリングを行い、システムを用いた課題解決を提案から改善まで一気通貫して行う。</span>");
    $("#internalCommunication").html("<span>チーム・シアトルの仲間の笑顔をつくるため、チーム会やグループ会、勉強会、イベントなどに積極的に企画/参加し、社内コミュニケーションを図る。<br>社内活動においてもロールモデルとなる言動を行う。</span>");
    $("#development").html("<span>チーム・シアトルの仲間の笑顔をつくるため、奉仕の気持ちを持ち、L1～L3メンバーを積極的に育成する。<br>また、次期L4メンバー候補となる人材の育成に尽力する。</span>");
    $("#itSkills").html("<span>システム構築に関わる基幹技術（OS、DB、ネットワーク、アプリケーション、インフラ、工数見積など）の全般的な知見を有し、お客様へ最適な提案を行うことができる。<br>IT戦略のトレンドを理解し、L1～L3メンバーに対してIT戦略を指導することができる。</span>");
    $("#understand").html("<span>お客様の事業内容に加えて個別の業界動向や競合他社に関する知見も有しており、経営層と同じ目線で会話をすることができる。<br>L1～L3メンバーに対し、その両面を指導、伝達することができる。</span>");
    $("#leadership").html("<span>プロジェクトを成功させるために必要なすべての業務を自ら洗い出しながら、主体的に取り組むことができる。<br>社内イベントでもメンバーの模範となる積極的な言動を行うことができる。</span>");
    $("#resolve").html("<span>自社やプロジェクトに加え、お客様の課題を自ら発見し、対応策を考え率先して解決にむけた取り組みを提案、実行することができる。</span>");
    $("#communication").html("<span>お客様とメンバーの橋渡し役として中核的な存在感を発揮するとともに、メンバーに対しコーチングを行い指導することができる。<br>お客様のニーズに合った的確なプレゼンテーションを行うことができる。</span>");
    $("#professional").html("<span>「ロジカルシンキング」「ゼロベース思考」「仮説思考」等の専門スキルを有し、お客様の課題解決を論理的に整理し、仮説を立て検証することができる。</span>");
    $("#fieldSales").html("<span>お客様との信頼関係をしっかり構築し、自チームの体制拡大や新規案件獲得に積極的に関わりながら、担当営業や上長を巻き込み推進していくことができる。</span>");
    $("#thanks").html("<span>“TeamTech move the world”を実現するために、つねに感謝の気持ちを持って人と接しよう。<br>「ありがとう」は人を笑顔にする魔法の言葉、たくさんの「ありがとう」を伝えて、たくさんの笑顔をつくっていこう。</span>");
    $("#engine").html("<span>“TeamTech move the world”を実現するために、ひとりひとりがチームや会社の原動力であるという当事者意識を持ち、主体的に提案や行動をしよう。<br>他責ではなくつねに自責で考え、自ら発信してチームや会社を動かしていこう。</span>");
    $("#all").html("<span>“TeamTech move the world”を実現するために、自分ひとりではなく、チームのため、会社のため、お客様のため、社会のため、といった広い視点を持とう。<br>自分目線だけでなく、相手がどう思うか、つねに利他の心を持って行動しよう。</span>");
    $("#masterpiece").html("<span>“TeamTech move the world”を実現するために、つねに全力を出し、最高傑作だと思えるアウトプットをしよう。<br>お客様やチームから喜ばれる仕事、感動を与える仕事をしよう。</span>");
    $("#stock").html("<span>“TeamTech move the world”を実現するために、たくさんの時間を共有して、信頼関係を築いていこう。<br>ひとりではできない経験やナレッジを蓄積し、お互いに成長していこう。</span>");
    $("#seattleBrand").html("<span>「カッコよくて仕事ができる」<br>気持ちの良い挨拶、素早いホウレンソウ、<br>失敗からまず報告、清潔感がある身だしなみ、<br>整理整頓、話をちゃんと聞く、勤怠良し、<br>土日も体調管理、高いセキュリティ意識</span>");
	break;
case "5PM":
    $("#satisfy").html("<span>お客様の笑顔をつくるため、CS評価シートの平均点が4.0点以上を獲得する。<br>または、お客様からの感謝状など表彰を受賞する。</span>");
    $("#commitment").html("<span>お客様の笑顔をつくるため、お客様の事業全体を成長させる視野を持ち、プロジェクトの全責任を担って完遂する。<br>QCDに加えて事業成長を意識し業務に取り組み、お客様の期待以上の水準で達成する。</span>");
    $("#proposal").html("<span>お客様の笑顔をつくるため、お客様の事業全体が成長する観点を持って、お客様に対して新たな付加価値や改善の企画、提案を行う。</span>");
    $("#internalCommunication").html("<span>チーム・シアトルの仲間の笑顔をつくるため、積極的にメンバーの意見に耳を傾けた上で、経営層とメンバーとの架け橋となるように、社内コミュニケーションを図る。<br>社内活動においてもロールモデルとなる言動を行う。</span>");
    $("#development").html("<span>チーム・シアトルの仲間の笑顔をつくるため、奉仕の気持ちを持ち、L1～L4メンバーの育成はもちろん、次期L5メンバー候補となる人材の育成にも尽力する。</span>");
    $("#itSkills").html("<span>要件定義/設計手法/テスト技法/見積手法など、プロジェクト運営に関わる全般的なITスキルを有し、お客様を成功へ導くことができる。<br>ITスキルのトレンドを理解しており、L1～L4メンバーに対してITスキルを指導することができる。</span>");
    $("#understand").html("<span>お客様の事業内容に加えて競合他社含めた業界状況を深く理解しており、お客様からの相談に乗ったり、教えることができる。<br>L1～L4メンバーに対し、わかりやすく指導、伝達することができる。</span>");
    $("#leadership").html("<span>プロジェクトはもちろんお客様の事業全体が成長するために必要なことを自ら見つけだし、提案型で業務を遂行していくことができる。<br>社内イベントでもメンバーの絶対的な模範として積極的な言動を行うことができる。</span>");
    $("#resolve").html("<span>この項目には必ず0．0を入力してください。</span>");
    $("#communication").html("<span>お客様やメンバーをはじめとしたステークホルダー全体を巻き込み、情報を収集・整理・周知しWin-Winな関係を構築することができる。<br>高度なコーチングやプレゼンテーションを行うことができる。</span>");
    $("#professional").html("<span>L4の専門力をベースに「財務管理」「人材管理」の専門スキルも有し、周囲の事柄や状況の本質を見極め、プロジェクトをトータルでプロデュースしながらお客様を成功に導くことができる。</span>");
    $("#fieldSales").html("<span>お客様と圧倒的な信頼関係を築きあげ、シアトルがナンバーワンの存在として体制拡大や新規案件を積極的に社内も巻き込んで提案していくことができる。</span>");
    $("#thanks").html("<span>“TeamTech move the world”を実現するために、つねに感謝の気持ちを持って人と接しよう。<br>「ありがとう」は人を笑顔にする魔法の言葉、たくさんの「ありがとう」を伝えて、たくさんの笑顔をつくっていこう。</span>");
    $("#engine").html("<span>“TeamTech move the world”を実現するために、ひとりひとりがチームや会社の原動力であるという当事者意識を持ち、主体的に提案や行動をしよう。<br>他責ではなくつねに自責で考え、自ら発信してチームや会社を動かしていこう。</span>");
    $("#all").html("<span>“TeamTech move the world”を実現するために、自分ひとりではなく、チームのため、会社のため、お客様のため、社会のため、といった広い視点を持とう。<br>自分目線だけでなく、相手がどう思うか、つねに利他の心を持って行動しよう。</span>");
    $("#masterpiece").html("<span>“TeamTech move the world”を実現するために、つねに全力を出し、最高傑作だと思えるアウトプットをしよう。<br>お客様やチームから喜ばれる仕事、感動を与える仕事をしよう。</span>");
    $("#stock").html("<span>“TeamTech move the world”を実現するために、たくさんの時間を共有して、信頼関係を築いていこう。<br>ひとりではできない経験やナレッジを蓄積し、お互いに成長していこう。</span>");
    $("#seattleBrand").html("<span>「カッコよくて仕事ができる」<br>気持ちの良い挨拶、素早いホウレンソウ、<br>失敗からまず報告、清潔感がある身だしなみ、<br>整理整頓、話をちゃんと聞く、勤怠良し、<br>土日も体調管理、高いセキュリティ意識</span>");
    break;
case "5アーキテクト":
    $("#satisfy").html("<span>お客様の笑顔をつくるため、CS評価シートの平均点が4.0点以上を獲得する。<br>または、お客様からの感謝状など表彰を受賞する。</span>");
    $("#commitment").html("<span>お客様の笑顔をつくるため、お客様の技術全体を統括・リードする存在として、プロジェクトの技術に関わる全責任を担って完遂する。<br>システム構成の最適化に加えて事業成長を意識し業務に取り組み、お客様の期待以上の水準で達成する。</span>");
    $("#proposal").html("<span>お客様の笑顔をつくるため、お客様の事業全体が成長する観点を持って、お客様に対して技術に関わる新たな付加価値や改善の企画、提案を行う。</span>");
    $("#internalCommunication").html("<span>チーム・シアトルの仲間の笑顔をつくるため、積極的にメンバーの意見に耳を傾けた上で、経営層とメンバーとの架け橋となるように、社内コミュニケーションを図る。<br>社内活動においてもロールモデルとなる言動を行う。</span>");
    $("#development").html("<span>チーム・シアトルの仲間の笑顔をつくるため、奉仕の気持ちを持ち、L1～L4メンバーの育成はもちろん、次期L5メンバー候補となる人材の育成にも尽力する。</span>");
    $("#itSkills").html("<span>情報システムの実現方式や開発手法に関する知見を深く有し、お客様に対してプロジェクト全体のデータモデリング/アプリケーション/インフラストラクチャ/開発方針を提案から行うことができる。<br>社内でも有数のITスキルを持ち、L1～L4メンバーに対して技術面でリードすることができる。</span>");
    $("#understand").html("<span>お客様の事業内容に加えて競合他社含めた業界状況を深く理解しており、お客様からの相談に乗ったり、教えることができる。<br>L1～L4メンバーに対し、わかりやすく指導、伝達することができる。</span>");
    $("#leadership").html("<span>プロジェクトはもちろんお客様の事業全体が成長するために必要なことを自ら見つけだし、提案型で業務を遂行していくことができる。<br>社内イベントでもメンバーの絶対的な模範として積極的な言動を行うことができる。</span>");
    $("#resolve").html("<span>この項目には絶対に0.0を入力してください。</span>");
    $("#communication").html("<span>お客様やメンバーをはじめとしたステークホルダー全体を巻き込み、情報を収集・整理・周知しWin-Winな関係を構築することができる。<br>高度なコーチングやプレゼンテーションを行うことができる。</span>");
    $("#professional").html("<span>「アーキテクチャ設計」「設計技法」「標準化と再利用」「ナレッジマネジメント」の専門スキルの複数において深い知見を有し、お客様のビジネス戦略を実現するために全体の品質を保ったシステムの立案、構築をすることができる。</span>");
    $("#fieldSales").html("<span>お客様と圧倒的な信頼関係を築きあげ、シアトルがナンバーワンの存在として体制拡大や新規案件を積極的に社内も巻き込んで提案していくことができる。</span>");
    $("#thanks").html("<span>“TeamTech move the world”を実現するために、つねに感謝の気持ちを持って人と接しよう。<br>「ありがとう」は人を笑顔にする魔法の言葉、たくさんの「ありがとう」を伝えて、たくさんの笑顔をつくっていこう。</span>");
    $("#engine").html("<span>“TeamTech move the world”を実現するために、ひとりひとりがチームや会社の原動力であるという当事者意識を持ち、主体的に提案や行動をしよう。<br>他責ではなくつねに自責で考え、自ら発信してチームや会社を動かしていこう。</span>");
    $("#all").html("<span>“TeamTech move the world”を実現するために、自分ひとりではなく、チームのため、会社のため、お客様のため、社会のため、といった広い視点を持とう。<br>自分目線だけでなく、相手がどう思うか、つねに利他の心を持って行動しよう。</span>");
    $("#masterpiece").html("<span>“TeamTech move the world”を実現するために、つねに全力を出し、最高傑作だと思えるアウトプットをしよう。<br>お客様やチームから喜ばれる仕事、感動を与える仕事をしよう。</span>");
    $("#stock").html("<span>“TeamTech move the world”を実現するために、たくさんの時間を共有して、信頼関係を築いていこう。<br>ひとりではできない経験やナレッジを蓄積し、お互いに成長していこう。</span>");
    $("#seattleBrand").html("<span>「カッコよくて仕事ができる」<br>気持ちの良い挨拶、素早いホウレンソウ、<br>失敗からまず報告、清潔感がある身だしなみ、<br>整理整頓、話をちゃんと聞く、勤怠良し、<br>土日も体調管理、高いセキュリティ意識</span>");
     break;
case "5コンサルタント":
    $("#satisfy").html("<span>お客様の笑顔をつくるため、CS評価シートの平均点が4.0点以上を獲得する。<br>または、お客様からの感謝状など表彰を受賞する。</span>");
    $("#commitment").html("<span>お客様の笑顔をつくるため、お客様の事業全体を成長させる視野を持ち、プロジェクトの全責任を担って完遂する。<br>システムだけでなくお客様のビジネス全体を俯瞰し、経営課題解決に向けた新しい付加価値を提案から改善まで行い、革新へと導く。</span>");
    $("#proposal").html("<span>お客様の笑顔をつくるため、お客様のビジネスプロセスや経営環境を深く理解し、他社ではできないような斬新なアイデアを駆使してお客様に提案を行って新たな発見を与える。</span>");
    $("#internalCommunication").html("<span>チーム・シアトルの仲間の笑顔をつくるため、積極的にメンバーの意見に耳を傾けた上で、経営層とメンバーとの架け橋となるように、社内コミュニケーションを図る 社内活動においてもロールモデルとなる言動を行う。</span>");
    $("#development").html("<span>チーム・シアトルの仲間の笑顔をつくるため、奉仕の気持ちを持ち、L1～L4メンバーの育成はもちろん、次期L5メンバー候補となる人材の育成にも尽力する。</span>");
    $("#itSkills").html("<span>新しいWebサービスやクラウドサービスの構築など「攻めのIT戦略」に関する技術的な知見を有し、お客様に対して新しい付加価値を提案することができる。<br>グローバルを含めたより広範囲なIT戦略のトレンドを理解しており、L1～L4メンバーに対してIT戦略を指導することができる。</span>");
    $("#understand").html("<span>お客様の事業内容に加えて業界全体や経営戦略に関する深い知見も有しており、経営層に対して提案から入っていくことができる。<br>L1～L4メンバーに対し、わかりやすく指導、伝達することができる。</span>");
    $("#leadership").html("<span>プロジェクトはもちろんお客様の事業全体が成長するために必要なことを自ら見つけだし、提案型で業務を遂行していくことができる。<br>社内イベントでもメンバーの絶対的な模範として積極的な言動を行うことができる。</span>");
    $("#resolve").html("<span>この項目には必ず0.0を入力してください。</span>");
    $("#communication").html("<span>お客様やメンバーをはじめとしたステークホルダー全体を巻き込み、情報を収集・整理・周知しWin-Winな関係を構築することができる。<br>高度なコーチングやプレゼンテーションを行うことができる。</span>");
    $("#professional").html("<span>L4の専門力をベースに、「経営戦略」「マーケティング」の専門スキルも有し、ITを切り口として戦略を考えるIT戦略立案・策定やシステム導入全体の舵取りを行って経営や業務、ユーザーに対して新しい付加価値を提供することができる。</span>");
    $("#fieldSales").html("<span>お客様と圧倒的な信頼関係を築きあげ、シアトルがナンバーワンの存在として体制拡大や新規案件を積極的に社内も巻き込んで提案していくことができる。</span>");
    $("#thanks").html("<span>“TeamTech move the world”を実現するために、つねに感謝の気持ちを持って人と接しよう。<br>「ありがとう」は人を笑顔にする魔法の言葉、たくさんの「ありがとう」を伝えて、たくさんの笑顔をつくっていこう。</span>");
    $("#engine").html("<span>“TeamTech move the world”を実現するために、ひとりひとりがチームや会社の原動力であるという当事者意識を持ち、主体的に提案や行動をしよう。<br>他責ではなくつねに自責で考え、自ら発信してチームや会社を動かしていこう。</span>");
    $("#all").html("<span>“TeamTech move the world”を実現するために、自分ひとりではなく、チームのため、会社のため、お客様のため、社会のため、といった広い視点を持とう。<br>自分目線だけでなく、相手がどう思うか、つねに利他の心を持って行動しよう。</span>");
    $("#masterpiece").html("<span>“TeamTech move the world”を実現するために、つねに全力を出し、最高傑作だと思えるアウトプットをしよう。<br>お客様やチームから喜ばれる仕事、感動を与える仕事をしよう。</span>");
    $("#stock").html("<span>“TeamTech move the world”を実現するために、たくさんの時間を共有して、信頼関係を築いていこう。<br>ひとりではできない経験やナレッジを蓄積し、お互いに成長していこう。</span>");
    $("#seattleBrand").html("<span>「カッコよくて仕事ができる」<br>気持ちの良い挨拶、素早いホウレンソウ、<br>失敗からまず報告、清潔感がある身だしなみ、<br>整理整頓、話をちゃんと聞く、勤怠良し、<br>土日も体調管理、高いセキュリティ意識</span>");
    break;
default:
    $("#satisfy").text("エンジニアレベルが選択されていません。");
    $("#commitment").text("エンジニアレベルが選択されていません。");
    $("#proposal").text("エンジニアレベルが選択されていません。");
    $("#internalCommunication").text("エンジニアレベルが選択されていません。");
    $("#development").text("エンジニアレベルが選択されていません。");
    $("#itSkills").text("エンジニアレベルが選択されていません。");
    $("#understand").text("エンジニアレベルが選択されていません。");
    $("#leadership").text("エンジニアレベルが選択されていません。");
    $("#resolve").text("エンジニアレベルが選択されていません。");
    $("#communication").text("エンジニアレベルが選択されていません。");
    $("#professional").text("エンジニアレベルが選択されていません。");
    $("#fieldSales").text("エンジニアレベルが選択されていません。");
    $("#thanks").text("エンジニアレベルが選択されていません。");
    $("#engine").text("エンジニアレベルが選択されていません。");
    $("#all").text("エンジニアレベルが選択されていません。");
    $("#masterpiece").text("エンジニアレベルが選択されていません。");
    $("#stock").text("エンジニアレベルが選択されていません。");
    $("#seattleBrand").text("エンジニアレベルが選択されていません。");
    
}

})



})

 