-- user role
INSERT INTO aord.user_role (name) VALUES ('ROLE_ADMIN');
INSERT INTO aord.user_role (name) VALUES ('ROLE_USER');

COMMIT;

-- user
INSERT INTO aord.user (email, password, user_role_id) VALUES ('test_admin@test.com', '$2a$10$VxlWOf3zYB994.HssX.TteM4NgOUiB0CkREYsvIWEyBgQjuJ.8PPW', 1);
INSERT INTO aord.user (email, password, user_role_id) VALUES ('test_user@test.com', '$2a$10$VxlWOf3zYB994.HssX.TteM4NgOUiB0CkREYsvIWEyBgQjuJ.8PPW', 2);

COMMIT;

-- probability
INSERT INTO aord.probability(code, description) VALUES (0.1, "jedva pojmljivo");
INSERT INTO aord.probability(code, description) VALUES (0.2, "praktično neverovatno");
INSERT INTO aord.probability(code, description) VALUES (0.5, "postoji, ali malo verovatno");
INSERT INTO aord.probability(code, description) VALUES (1, "moguće u ograničenim slučajevima (mala verovatnoća)");
INSERT INTO aord.probability(code, description) VALUES (3, "nije aktuelno, ali je moguće (malo moguće)");
INSERT INTO aord.probability(code, description) VALUES (6, "apsolutno moguće");
INSERT INTO aord.probability(code, description) VALUES (10, "predvidivo, očekivano");

COMMIT;

-- effect
INSERT INTO aord.effect (code, description) VALUES (1, "mali (male povrede bez bolovanja)");
INSERT INTO aord.effect (code, description) VALUES (2, "znatne (medicinski tretman i bolovanje)");
INSERT INTO aord.effect (code, description) VALUES (3, "ozbiljne (povreda sa ozbiljnim posledicama , hospitalizacija, moguć invaliditet)");
INSERT INTO aord.effect (code, description) VALUES (6, "veoma ozbiljan / jedan smrtni slučaj");
INSERT INTO aord.effect (code, description) VALUES (10, "katastrofalan (višestruki smrtni ishod)");

COMMIT;

-- frequency
INSERT INTO aord.frequency (code, description) VALUES (1, "retko (godišnje)");
INSERT INTO aord.frequency (code, description) VALUES (2, "ponekad (mesečno)");
INSERT INTO aord.frequency (code, description) VALUES (3, "povremeno (nedeljno)");
INSERT INTO aord.frequency (code, description) VALUES (6, "redovno (dnevno)");
INSERT INTO aord.frequency (code, description) VALUES (10, "stalno – kontinualno");

COMMIT;

-- kinney_index
INSERT INTO aord.kinney_index(value, description, probability_id, effect_id, frequency_id) VALUES (1, "veoma mali rizik – prihvatljivo", 3, 1, 2);
INSERT INTO aord.kinney_index(value, description, probability_id, effect_id, frequency_id) VALUES (40, "mali rizik - obratiti pažnju, rešiti ga redovnom procedurom", 7, 2, 2);

COMMIT;

-- danger_type
INSERT INTO aord.danger_type (name) VALUES ("Mehaničke opasnosti (koje se pojavljuju korišćenjem opreme za rad)");
INSERT INTO aord.danger_type (name) VALUES ("Opasnosti koji se pojavljuju u vezi sa karakteristikama radnih mesta");
INSERT INTO aord.danger_type (name) VALUES ("Opasnosti koje se pojavljuju korišćenjem električne energije");
INSERT INTO aord.danger_type (name) VALUES ("Štetnosti koje nastaju ili se pojavljuju u procesu rada");
INSERT INTO aord.danger_type (name) VALUES ("Štetnosti koje proističu iz psihičkih i psihofizičkih napora");
INSERT INTO aord.danger_type (name) VALUES ("Ostale štetnosti");

COMMIT;

-- danger_name
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (1, 1, "Nedovoljna bezbednost zbog rotirajućih ili pokretnih delova");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (1, 2, "Slobodno kretanje delova ili materijala koji mogu naneti povredu zaposlenom");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (1, 3, "Unutrašnji transport i kretanje radnih mašina ili vozila, kao i pomeranja određene opreme za rad");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (1, 4, "Korišćenje opasnih sredstava za rad koja mogu proizvesti eksplozije ili požar");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (1, 5, "Nemogućnost ili ograničenost pravovremenog uklanjanja sa mesta rada, izloženost zatvaranju,mehaničkom udaru, poklapanju i sl.");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (1, 6, "Drugi faktori koji mogu da se pojave kao mehanički izvori opasnosti");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (2, 7, "Opasne površine (podovi i sve vrste gazišta, površine sa kojima zaposleni dolazi u dodir, a koje imaju oštre ivice - rubove, šiljke, grube površine, izbočene delove, i sl.)");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (2, 8, "Rad na visini ili u dubini, u smislu propisa o bezbednosti i zdravlju na radu");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (2, 10, "Mogućnost klizanja ili spoticanja (mokre ili klizave površine)");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (2, 11, "Fizička nestabilnost radnog mesta");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (2, 12, "Moguće posledice ili smetnje usled obavezne upotrebe sredstava ili opreme za ličnu zaštitu na radu");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (2, 13, "Uticaji usled obavljanja procesa rada korišćenjem neodgovarajućih ili neprilagođenih metoda rada");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (2, 14, "Druge opasnosti koje se mogu pojaviti u vezi sa karakteristikama radnog mesta i načinom rada (korišćenje sredstava i opreme za ličnu zaštitu na radu koja opterećuju zaposlenog, i sl.)");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (3, 15, "Opasnost od direktnog dodira sa delovima električne instalacije i opreme pod naponom");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (3, 16, "Opasnost od indirektnog dodira");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (3, 17, "Opasnost od toplotnog dejstva koje razvijaju električna oprema i instalacije (pregrevanje, požar, eksplozija, električni luk ili varničenje, i dr.)");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (3, 18, "Opasnosti usled udara groma i posledica atmosferskog pražnjenja");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (3, 19, "Opasnost od štetnog uticaja elektrostatičkog naelektrisanja");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (3, 20, "Druge opasnosti koje se mogu pojaviti u vezi sa korišćenjem električne energije");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (4, 21, "Hemijske štetnosti (udisanje, gušenje, unošenje u organizam, prodor u telo kroz kožu, i sl.), prašina,dimovi, opekotine,trovanje");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (4, 22, "Fizičke štetnosti, buka i vibracije");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (4, 23, "Biološke štetnosti, infekcije, izlaganje mikroorganizmima, alergentima");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (4, 24, "Štetni uticaji mikroklime, visoka temperatura,niska temperatura,vlažnost vazduha,brzina strujanja vazduha");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (4, 25, "Neodgovarajuća - nedovoljna osvetljenost");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (4, 26, "Štetni uticaji zračenja,toplotnog, jonizujućeg, ultravioletnog, nejonizujućeg, laserskog, ultrazvučnog");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (4, 27, "Štetni klimatski uticaji, rad na otvorenom");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (4, 28, "Štetnosti koje nastaju korišćenjem opasnih materija u proizvodnji, transportu, pakovanju, skladištenju ili uništavanju (klase 1,2,...9)");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (4, 29, "Druge štetnosti koje se pojavljuju u radnom procesu, a koje mogu da budu uzrok povrede na radu zaposlenog, profesionalnog oboljena ili oboljenja u vezi sa radom");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (5, 30, "Napori ili telesna naprezanja (ručno prenošenje tereta, guranje ili vučenje tereta, razne dugotrajne povećane telesne aktivnosti)");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (5, 31, "Nefiziološki položaj tela (dugotrajno stajanje, sedenje, čučanje, klečanje)");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (5, 32, "Napori pri obavljanju određenih poslova koji prouzrokuju psihološka opterećenja (stres, monotonija)");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (5, 34, "Štetnosti vezane za organizaciju rada (rad duži od punog radnog vremena-prekovremeni rad, rad u smenama, skraćeno radno vreme, rad noću, pripravnost za slučaj intervencija, i sl.)");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (6, 35, "Štetnosti koje prouzrokuju druga lica (nasilje prema licima koja rade na šalterima, lica na obezbeđenju, i sl.)");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (6, 36, "Rad sa životinjama");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (6, 37, "Rad u atmosferi sa visokim ili niskim pritiskom");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (6, 38, "Rad u blizini vode ili ispod površine vode");
INSERT INTO aord.danger_name (danger_type_id, danger_number, description) VALUES (6, 39, "Ostale opasnosti odnosno štetnosti");

COMMIT;


---- danger_details
--INSERT INTO aord.danger_details (code, danger_name_id, descriptions, probability_id, effect_id, frequency_id, value) VALUES (1, 1, "Rad sa trimerom, kosilicom, motorna testera", 5, 3, 4, 54);
--INSERT INTO aord.danger_details (code, danger_name_id, descriptions, probability_id, effect_id, frequency_id, value) VALUES (2, 2, CONCAT_WS(";", "pad tereta i predmeta sa visine", "pad predmeta opreme za rad iz ruku zbog nepažnje zaposlenog, povrede donjih ekstremiteta", "odletanje čestica, slobodno kretanje delova ili materijala koje mogu naneti povredu"), 5, 3, 4, 54);
--INSERT INTO aord.danger_details (code, danger_name_id, descriptions, probability_id, effect_id, frequency_id, value) VALUES (3, 3, CONCAT_WS(";", "potencijalna opasnost od udara u predmete usled nepažnje", "rad u zoni putnog pojasa pod saobraćajem"), 5, 4, 3, 54);
--INSERT INTO aord.danger_details (code, danger_name_id, descriptions, probability_id, effect_id, frequency_id, value) VALUES (6, 6, CONCAT_WS(";", "opasnost od požara", "opasnost pri učestvovanju u javnom saobraćaju vozilom ili pri korišćenju prevoza javnog saobraćaja, mogućnost saobraćajne nesreće"), 4, 3, 4, 18);
--
--COMMIT;
--
----risk_removal_measurement
--INSERT INTO aord.risk_removal_measurement (risk_factor_value, description, measurement_impl_freq, danger_details_id) VALUES (54, "Strogo je zabranjeno da se uklanja fabrička zaštita sa opreme za rad, štitnika i zaštite prenosnika snage. Zabranjena je u upotreba bilo kakvih alata i opreme na kojima je vršena modifikacija, odnosno bilo kakva odstupanja u odnosu na fabričko stanje. Obavezno izvršiti vizuelni pregled pre upotrebe opreme za rad, a takođe u pauzama radova proveriti ispravnost i funkcionalnost sigurnosnih sklopova i spojeva. Mašine, alate i opremu koristiti isključivo prema nameni, odnosno u skladu sa uputstvom za upotrebu proizvođača. Tokom korišćenja opreme i alata na mehanizovani pogon neophodna je upotreba ličnih zaštitnih sredstava prema upustvu proizvođača opreme za rad i u skladu sa aktom o proceni rizika.", "Stalno", 1);
--INSERT INTO aord.risk_removal_measurement (risk_factor_value, description, measurement_impl_freq, danger_details_id) VALUES (54, "Opreznost u radu je neophodna puno radno vreme. Prekontrolisati ispravnost opreme i alata pre početka rada. Sigurno i pravilno pričvršćivanje reznog alata; Prilikom prenošenja materijala i opreme ne kretati se ispod tereta. Pridržavanje usvojenih uputstva za bezbedan rad. Ne žuriti sa pripremom i izvršavanjem radnih aktivnosti. Raditi ujednačeno i postupno (po redosledu radnji bez preskakanja).", "Stalno", 2);
--INSERT INTO aord.risk_removal_measurement (risk_factor_value, description, measurement_impl_freq, danger_details_id) VALUES (54, "Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.", "Stalno", 3);
--INSERT INTO aord.risk_removal_measurement (risk_factor_value, description, measurement_impl_freq, danger_details_id) VALUES (18, "Dati prednost organizovanom ili javnom prevozu za dolazak i odlazak sa posla. Ukoliko se upravlja vozilom neophodno je striktno poštovanje saobraćajnih propisa. Prilagođavanje vožnje uslovima na putu usled loših vremenskih uslova, saobraćajne gužve, sporohodnih vozila i sl. Održavanje vozila u tehnički ispravnom i bezbednom stanju, zamena sezonskih pneumatika je neophodna. Zabranjena je upotreba mobilnog telefona u toku vožnje, i obavezna upotreba zaštitnog pojasa u vozilu tokom vožnje. Obezbediti aparat za početno gašenje požara u vozilu, i na mestu rada, naročito tokom upotrebe gorivih ili zapaljivih materija.", "Stalno", 4);
--
--COMMIT;