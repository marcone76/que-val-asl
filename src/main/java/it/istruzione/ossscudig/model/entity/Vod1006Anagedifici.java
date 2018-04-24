package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the VOD1006_ANAGEDIFICI database table.
 * 
 */
@Entity
@Table(name="VOD1006_ANAGEDIFICI")
@NamedQuery(name="Vod1006Anagedifici.findAll", query="SELECT v FROM Vod1006Anagedifici v")
public class Vod1006Anagedifici implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_EDI")
	private String codEdi;

	@Column(name="COD_POL_EDI_SCO")
	private String codPolEdiSco;
	
	private String a001;

	private String a002;

	private String a003;

	private String a004;

	private String a006;

	private String a008;

	private String a009;

	private String a010;

	private String a011;

	private String a012;

	private String a013;

	private String a014;

	private String a015;

	private String a016;

	private String a017;

	private String a018;

	private String a019;

	private String a020;

	private String a021;

	private String a022;

	private String a023;

	private String a024;

	private String a025;

	private String a026;

	private String a027;

	private String a028;

	private String a029;

	private String a030;

	private String a031;

	private String a032;

	private String a033;

	private String a034;

	private String a035;

	private String a036;

	private String a037;

	private String a038;

	private String a039;

	private String a040;

	private String a041;

	private String a042;

	private String a043;

	private String a044;

	private String a045;

	private String a046;

	private String a047;

	private String a048;

	private String a049;

	private String a050;

	private String a051;

	private String a052;

	private String a053;

	private String a054;

	private String a055;

	private String a056;

	private String a057;

	private String a058;

	private String a059;

	private String a060;

	private String a061;

	private String a062;

	private String a063;

	private String a064;

	private String a065;

	private BigDecimal a066;

	private String a067;

	private BigDecimal a068;

	private String a069;

	private BigDecimal a070;

	private String a071;

	private String a072;

	private String a073;

	private String a074;

	private String a075;

	private String a076;

	private String a077;

	private String a078;

	private String a079;

	private String a080;

	private String a081;

	private String a082;

	private String a083;

	private String a084;

	private String a085;

	private String a086;

	private String a087;

	private String a088;

	private String a089;

	private String a090;

	private String a091;

	private String a092;

	private String a093;

	private String a094;

	private String a095;

	private String a096;

	private String a097;

	private String a098;

	private String a099;

	private String a100;

	private String a101;

	private String a102;

	private String a103;

	private String a104;

	private String a105;

	private String a106;

	private String a107;

	private String a108;

	private String a109;

	private String a110;

	private String a111;

	private String a112;

	private String a113;

	private String a114;

	private String a115;

	private String a116;

	private String a117;

	private String a118;

	private String a119;

	private String a120;

	private String a121;

	private String a122;

	private String a123;

	private String a124;

	private String a125;

	private String a126;

	private String a127;

	private String a128;

	private String a129;

	private String a130;

	private String a131;

	private String a132;

	private String a133;

	private String a134;

	private String a135;

	private String a136;

	private String a137;

	private String a138;

	private String a139;

	private String a140;

	private String a141;

	private String a142;

	private String a143;

	private String a144;

	private String a145;

	private String a146;

	private String a147;

	private String a148;

	private String a149;

	private String a150;

	private String a151;

	private String a152;

	private String a153;

	private String a154;

	private String a155;

	private String a156;

	private String a157;

	public Vod1006Anagedifici() {
	}

	public String getA001() {
		return this.a001;
	}

	public void setA001(String a001) {
		this.a001 = a001;
	}

	public String getA002() {
		return this.a002;
	}

	public void setA002(String a002) {
		this.a002 = a002;
	}

	public String getA003() {
		return this.a003;
	}

	public void setA003(String a003) {
		this.a003 = a003;
	}

	public String getA004() {
		return this.a004;
	}

	public void setA004(String a004) {
		this.a004 = a004;
	}

	public String getA006() {
		return this.a006;
	}

	public void setA006(String a006) {
		this.a006 = a006;
	}

	public String getA008() {
		return this.a008;
	}

	public void setA008(String a008) {
		this.a008 = a008;
	}

	public String getA009() {
		return this.a009;
	}

	public void setA009(String a009) {
		this.a009 = a009;
	}

	public String getA010() {
		return this.a010;
	}

	public void setA010(String a010) {
		this.a010 = a010;
	}

	public String getA011() {
		return this.a011;
	}

	public void setA011(String a011) {
		this.a011 = a011;
	}

	public String getA012() {
		return this.a012;
	}

	public void setA012(String a012) {
		this.a012 = a012;
	}

	public String getA013() {
		return this.a013;
	}

	public void setA013(String a013) {
		this.a013 = a013;
	}

	public String getA014() {
		return this.a014;
	}

	public void setA014(String a014) {
		this.a014 = a014;
	}

	public String getA015() {
		return this.a015;
	}

	public void setA015(String a015) {
		this.a015 = a015;
	}

	public String getA016() {
		return this.a016;
	}

	public void setA016(String a016) {
		this.a016 = a016;
	}

	public String getA017() {
		return this.a017;
	}

	public void setA017(String a017) {
		this.a017 = a017;
	}

	public String getA018() {
		return this.a018;
	}

	public void setA018(String a018) {
		this.a018 = a018;
	}

	public String getA019() {
		return this.a019;
	}

	public void setA019(String a019) {
		this.a019 = a019;
	}

	public String getA020() {
		return this.a020;
	}

	public void setA020(String a020) {
		this.a020 = a020;
	}

	public String getA021() {
		return this.a021;
	}

	public void setA021(String a021) {
		this.a021 = a021;
	}

	public String getA022() {
		return this.a022;
	}

	public void setA022(String a022) {
		this.a022 = a022;
	}

	public String getA023() {
		return this.a023;
	}

	public void setA023(String a023) {
		this.a023 = a023;
	}

	public String getA024() {
		return this.a024;
	}

	public void setA024(String a024) {
		this.a024 = a024;
	}

	public String getA025() {
		return this.a025;
	}

	public void setA025(String a025) {
		this.a025 = a025;
	}

	public String getA026() {
		return this.a026;
	}

	public void setA026(String a026) {
		this.a026 = a026;
	}

	public String getA027() {
		return this.a027;
	}

	public void setA027(String a027) {
		this.a027 = a027;
	}

	public String getA028() {
		return this.a028;
	}

	public void setA028(String a028) {
		this.a028 = a028;
	}

	public String getA029() {
		return this.a029;
	}

	public void setA029(String a029) {
		this.a029 = a029;
	}

	public String getA030() {
		return this.a030;
	}

	public void setA030(String a030) {
		this.a030 = a030;
	}

	public String getA031() {
		return this.a031;
	}

	public void setA031(String a031) {
		this.a031 = a031;
	}

	public String getA032() {
		return this.a032;
	}

	public void setA032(String a032) {
		this.a032 = a032;
	}

	public String getA033() {
		return this.a033;
	}

	public void setA033(String a033) {
		this.a033 = a033;
	}

	public String getA034() {
		return this.a034;
	}

	public void setA034(String a034) {
		this.a034 = a034;
	}

	public String getA035() {
		return this.a035;
	}

	public void setA035(String a035) {
		this.a035 = a035;
	}

	public String getA036() {
		return this.a036;
	}

	public void setA036(String a036) {
		this.a036 = a036;
	}

	public String getA037() {
		return this.a037;
	}

	public void setA037(String a037) {
		this.a037 = a037;
	}

	public String getA038() {
		return this.a038;
	}

	public void setA038(String a038) {
		this.a038 = a038;
	}

	public String getA039() {
		return this.a039;
	}

	public void setA039(String a039) {
		this.a039 = a039;
	}

	public String getA040() {
		return this.a040;
	}

	public void setA040(String a040) {
		this.a040 = a040;
	}

	public String getA041() {
		return this.a041;
	}

	public void setA041(String a041) {
		this.a041 = a041;
	}

	public String getA042() {
		return this.a042;
	}

	public void setA042(String a042) {
		this.a042 = a042;
	}

	public String getA043() {
		return this.a043;
	}

	public void setA043(String a043) {
		this.a043 = a043;
	}

	public String getA044() {
		return this.a044;
	}

	public void setA044(String a044) {
		this.a044 = a044;
	}

	public String getA045() {
		return this.a045;
	}

	public void setA045(String a045) {
		this.a045 = a045;
	}

	public String getA046() {
		return this.a046;
	}

	public void setA046(String a046) {
		this.a046 = a046;
	}

	public String getA047() {
		return this.a047;
	}

	public void setA047(String a047) {
		this.a047 = a047;
	}

	public String getA048() {
		return this.a048;
	}

	public void setA048(String a048) {
		this.a048 = a048;
	}

	public String getA049() {
		return this.a049;
	}

	public void setA049(String a049) {
		this.a049 = a049;
	}

	public String getA050() {
		return this.a050;
	}

	public void setA050(String a050) {
		this.a050 = a050;
	}

	public String getA051() {
		return this.a051;
	}

	public void setA051(String a051) {
		this.a051 = a051;
	}

	public String getA052() {
		return this.a052;
	}

	public void setA052(String a052) {
		this.a052 = a052;
	}

	public String getA053() {
		return this.a053;
	}

	public void setA053(String a053) {
		this.a053 = a053;
	}

	public String getA054() {
		return this.a054;
	}

	public void setA054(String a054) {
		this.a054 = a054;
	}

	public String getA055() {
		return this.a055;
	}

	public void setA055(String a055) {
		this.a055 = a055;
	}

	public String getA056() {
		return this.a056;
	}

	public void setA056(String a056) {
		this.a056 = a056;
	}

	public String getA057() {
		return this.a057;
	}

	public void setA057(String a057) {
		this.a057 = a057;
	}

	public String getA058() {
		return this.a058;
	}

	public void setA058(String a058) {
		this.a058 = a058;
	}

	public String getA059() {
		return this.a059;
	}

	public void setA059(String a059) {
		this.a059 = a059;
	}

	public String getA060() {
		return this.a060;
	}

	public void setA060(String a060) {
		this.a060 = a060;
	}

	public String getA061() {
		return this.a061;
	}

	public void setA061(String a061) {
		this.a061 = a061;
	}

	public String getA062() {
		return this.a062;
	}

	public void setA062(String a062) {
		this.a062 = a062;
	}

	public String getA063() {
		return this.a063;
	}

	public void setA063(String a063) {
		this.a063 = a063;
	}

	public String getA064() {
		return this.a064;
	}

	public void setA064(String a064) {
		this.a064 = a064;
	}

	public String getA065() {
		return this.a065;
	}

	public void setA065(String a065) {
		this.a065 = a065;
	}

	public BigDecimal getA066() {
		return this.a066;
	}

	public void setA066(BigDecimal a066) {
		this.a066 = a066;
	}

	public String getA067() {
		return this.a067;
	}

	public void setA067(String a067) {
		this.a067 = a067;
	}

	public BigDecimal getA068() {
		return this.a068;
	}

	public void setA068(BigDecimal a068) {
		this.a068 = a068;
	}

	public String getA069() {
		return this.a069;
	}

	public void setA069(String a069) {
		this.a069 = a069;
	}

	public BigDecimal getA070() {
		return this.a070;
	}

	public void setA070(BigDecimal a070) {
		this.a070 = a070;
	}

	public String getA071() {
		return this.a071;
	}

	public void setA071(String a071) {
		this.a071 = a071;
	}

	public String getA072() {
		return this.a072;
	}

	public void setA072(String a072) {
		this.a072 = a072;
	}

	public String getA073() {
		return this.a073;
	}

	public void setA073(String a073) {
		this.a073 = a073;
	}

	public String getA074() {
		return this.a074;
	}

	public void setA074(String a074) {
		this.a074 = a074;
	}

	public String getA075() {
		return this.a075;
	}

	public void setA075(String a075) {
		this.a075 = a075;
	}

	public String getA076() {
		return this.a076;
	}

	public void setA076(String a076) {
		this.a076 = a076;
	}

	public String getA077() {
		return this.a077;
	}

	public void setA077(String a077) {
		this.a077 = a077;
	}

	public String getA078() {
		return this.a078;
	}

	public void setA078(String a078) {
		this.a078 = a078;
	}

	public String getA079() {
		return this.a079;
	}

	public void setA079(String a079) {
		this.a079 = a079;
	}

	public String getA080() {
		return this.a080;
	}

	public void setA080(String a080) {
		this.a080 = a080;
	}

	public String getA081() {
		return this.a081;
	}

	public void setA081(String a081) {
		this.a081 = a081;
	}

	public String getA082() {
		return this.a082;
	}

	public void setA082(String a082) {
		this.a082 = a082;
	}

	public String getA083() {
		return this.a083;
	}

	public void setA083(String a083) {
		this.a083 = a083;
	}

	public String getA084() {
		return this.a084;
	}

	public void setA084(String a084) {
		this.a084 = a084;
	}

	public String getA085() {
		return this.a085;
	}

	public void setA085(String a085) {
		this.a085 = a085;
	}

	public String getA086() {
		return this.a086;
	}

	public void setA086(String a086) {
		this.a086 = a086;
	}

	public String getA087() {
		return this.a087;
	}

	public void setA087(String a087) {
		this.a087 = a087;
	}

	public String getA088() {
		return this.a088;
	}

	public void setA088(String a088) {
		this.a088 = a088;
	}

	public String getA089() {
		return this.a089;
	}

	public void setA089(String a089) {
		this.a089 = a089;
	}

	public String getA090() {
		return this.a090;
	}

	public void setA090(String a090) {
		this.a090 = a090;
	}

	public String getA091() {
		return this.a091;
	}

	public void setA091(String a091) {
		this.a091 = a091;
	}

	public String getA092() {
		return this.a092;
	}

	public void setA092(String a092) {
		this.a092 = a092;
	}

	public String getA093() {
		return this.a093;
	}

	public void setA093(String a093) {
		this.a093 = a093;
	}

	public String getA094() {
		return this.a094;
	}

	public void setA094(String a094) {
		this.a094 = a094;
	}

	public String getA095() {
		return this.a095;
	}

	public void setA095(String a095) {
		this.a095 = a095;
	}

	public String getA096() {
		return this.a096;
	}

	public void setA096(String a096) {
		this.a096 = a096;
	}

	public String getA097() {
		return this.a097;
	}

	public void setA097(String a097) {
		this.a097 = a097;
	}

	public String getA098() {
		return this.a098;
	}

	public void setA098(String a098) {
		this.a098 = a098;
	}

	public String getA099() {
		return this.a099;
	}

	public void setA099(String a099) {
		this.a099 = a099;
	}

	public String getA100() {
		return this.a100;
	}

	public void setA100(String a100) {
		this.a100 = a100;
	}

	public String getA101() {
		return this.a101;
	}

	public void setA101(String a101) {
		this.a101 = a101;
	}

	public String getA102() {
		return this.a102;
	}

	public void setA102(String a102) {
		this.a102 = a102;
	}

	public String getA103() {
		return this.a103;
	}

	public void setA103(String a103) {
		this.a103 = a103;
	}

	public String getA104() {
		return this.a104;
	}

	public void setA104(String a104) {
		this.a104 = a104;
	}

	public String getA105() {
		return this.a105;
	}

	public void setA105(String a105) {
		this.a105 = a105;
	}

	public String getA106() {
		return this.a106;
	}

	public void setA106(String a106) {
		this.a106 = a106;
	}

	public String getA107() {
		return this.a107;
	}

	public void setA107(String a107) {
		this.a107 = a107;
	}

	public String getA108() {
		return this.a108;
	}

	public void setA108(String a108) {
		this.a108 = a108;
	}

	public String getA109() {
		return this.a109;
	}

	public void setA109(String a109) {
		this.a109 = a109;
	}

	public String getA110() {
		return this.a110;
	}

	public void setA110(String a110) {
		this.a110 = a110;
	}

	public String getA111() {
		return this.a111;
	}

	public void setA111(String a111) {
		this.a111 = a111;
	}

	public String getA112() {
		return this.a112;
	}

	public void setA112(String a112) {
		this.a112 = a112;
	}

	public String getA113() {
		return this.a113;
	}

	public void setA113(String a113) {
		this.a113 = a113;
	}

	public String getA114() {
		return this.a114;
	}

	public void setA114(String a114) {
		this.a114 = a114;
	}

	public String getA115() {
		return this.a115;
	}

	public void setA115(String a115) {
		this.a115 = a115;
	}

	public String getA116() {
		return this.a116;
	}

	public void setA116(String a116) {
		this.a116 = a116;
	}

	public String getA117() {
		return this.a117;
	}

	public void setA117(String a117) {
		this.a117 = a117;
	}

	public String getA118() {
		return this.a118;
	}

	public void setA118(String a118) {
		this.a118 = a118;
	}

	public String getA119() {
		return this.a119;
	}

	public void setA119(String a119) {
		this.a119 = a119;
	}

	public String getA120() {
		return this.a120;
	}

	public void setA120(String a120) {
		this.a120 = a120;
	}

	public String getA121() {
		return this.a121;
	}

	public void setA121(String a121) {
		this.a121 = a121;
	}

	public String getA122() {
		return this.a122;
	}

	public void setA122(String a122) {
		this.a122 = a122;
	}

	public String getA123() {
		return this.a123;
	}

	public void setA123(String a123) {
		this.a123 = a123;
	}

	public String getA124() {
		return this.a124;
	}

	public void setA124(String a124) {
		this.a124 = a124;
	}

	public String getA125() {
		return this.a125;
	}

	public void setA125(String a125) {
		this.a125 = a125;
	}

	public String getA126() {
		return this.a126;
	}

	public void setA126(String a126) {
		this.a126 = a126;
	}

	public String getA127() {
		return this.a127;
	}

	public void setA127(String a127) {
		this.a127 = a127;
	}

	public String getA128() {
		return this.a128;
	}

	public void setA128(String a128) {
		this.a128 = a128;
	}

	public String getA129() {
		return this.a129;
	}

	public void setA129(String a129) {
		this.a129 = a129;
	}

	public String getA130() {
		return this.a130;
	}

	public void setA130(String a130) {
		this.a130 = a130;
	}

	public String getA131() {
		return this.a131;
	}

	public void setA131(String a131) {
		this.a131 = a131;
	}

	public String getA132() {
		return this.a132;
	}

	public void setA132(String a132) {
		this.a132 = a132;
	}

	public String getA133() {
		return this.a133;
	}

	public void setA133(String a133) {
		this.a133 = a133;
	}

	public String getA134() {
		return this.a134;
	}

	public void setA134(String a134) {
		this.a134 = a134;
	}

	public String getA135() {
		return this.a135;
	}

	public void setA135(String a135) {
		this.a135 = a135;
	}

	public String getA136() {
		return this.a136;
	}

	public void setA136(String a136) {
		this.a136 = a136;
	}

	public String getA137() {
		return this.a137;
	}

	public void setA137(String a137) {
		this.a137 = a137;
	}

	public String getA138() {
		return this.a138;
	}

	public void setA138(String a138) {
		this.a138 = a138;
	}

	public String getA139() {
		return this.a139;
	}

	public void setA139(String a139) {
		this.a139 = a139;
	}

	public String getA140() {
		return this.a140;
	}

	public void setA140(String a140) {
		this.a140 = a140;
	}

	public String getA141() {
		return this.a141;
	}

	public void setA141(String a141) {
		this.a141 = a141;
	}

	public String getA142() {
		return this.a142;
	}

	public void setA142(String a142) {
		this.a142 = a142;
	}

	public String getA143() {
		return this.a143;
	}

	public void setA143(String a143) {
		this.a143 = a143;
	}

	public String getA144() {
		return this.a144;
	}

	public void setA144(String a144) {
		this.a144 = a144;
	}

	public String getA145() {
		return this.a145;
	}

	public void setA145(String a145) {
		this.a145 = a145;
	}

	public String getA146() {
		return this.a146;
	}

	public void setA146(String a146) {
		this.a146 = a146;
	}

	public String getA147() {
		return this.a147;
	}

	public void setA147(String a147) {
		this.a147 = a147;
	}

	public String getA148() {
		return this.a148;
	}

	public void setA148(String a148) {
		this.a148 = a148;
	}

	public String getA149() {
		return this.a149;
	}

	public void setA149(String a149) {
		this.a149 = a149;
	}

	public String getA150() {
		return this.a150;
	}

	public void setA150(String a150) {
		this.a150 = a150;
	}

	public String getA151() {
		return this.a151;
	}

	public void setA151(String a151) {
		this.a151 = a151;
	}

	public String getA152() {
		return this.a152;
	}

	public void setA152(String a152) {
		this.a152 = a152;
	}

	public String getA153() {
		return this.a153;
	}

	public void setA153(String a153) {
		this.a153 = a153;
	}

	public String getA154() {
		return this.a154;
	}

	public void setA154(String a154) {
		this.a154 = a154;
	}

	public String getA155() {
		return this.a155;
	}

	public void setA155(String a155) {
		this.a155 = a155;
	}

	public String getA156() {
		return this.a156;
	}

	public void setA156(String a156) {
		this.a156 = a156;
	}

	public String getA157() {
		return this.a157;
	}

	public void setA157(String a157) {
		this.a157 = a157;
	}

	public String getCodEdi() {
		return this.codEdi;
	}

	public void setCodEdi(String codEdi) {
		this.codEdi = codEdi;
	}

	public String getCodPolEdiSco() {
		return this.codPolEdiSco;
	}

	public void setCodPolEdiSco(String codPolEdiSco) {
		this.codPolEdiSco = codPolEdiSco;
	}

}