-- user role
INSERT INTO aord.user_role (name) VALUES ('ROLE_ADMIN');
INSERT INTO aord.user_role (name) VALUES ('ROLE_USER');

COMMIT;

-- user
INSERT INTO aord.user (email, password, user_role_id) VALUES ('test_admin@test.com', '$2a$10$VxlWOf3zYB994.HssX.TteM4NgOUiB0CkREYsvIWEyBgQjuJ.8PPW', 1);
INSERT INTO aord.user (email, password, user_role_id) VALUES ('test_user@test.com', '$2a$10$VxlWOf3zYB994.HssX.TteM4NgOUiB0CkREYsvIWEyBgQjuJ.8PPW', 2);

COMMIT;

-- probability
INSERT INTO aord.probability(value, description) VALUES (0.1, "jedva pojmljivo");
INSERT INTO aord.probability(value, description) VALUES (0.2, "praktično neverovatno");
INSERT INTO aord.probability(value, description) VALUES (0.5, "postoji, ali malo verovatno");
INSERT INTO aord.probability(value, description) VALUES (1, "moguće u ograničenim slučajevima (mala verovatnoća)");
INSERT INTO aord.probability(value, description) VALUES (3, "nije aktuelno, ali je moguće (malo moguće)");
INSERT INTO aord.probability(value, description) VALUES (6, "apsolutno moguće");
INSERT INTO aord.probability(value, description) VALUES (10, "predvidivo, očekivano");

COMMIT;

-- effect
INSERT INTO aord.effect (value, description) VALUES (1, "mali (male povrede bez bolovanja)");
INSERT INTO aord.effect (value, description) VALUES (2, "znatne (medicinski tretman i bolovanje)");
INSERT INTO aord.effect (value, description) VALUES (3, "ozbiljne (povreda sa ozbiljnim posledicama , hospitalizacija, moguć invaliditet)");
INSERT INTO aord.effect (value, description) VALUES (6, "veoma ozbiljan / jedan smrtni slučaj");
INSERT INTO aord.effect (value, description) VALUES (10, "katastrofalan (višestruki smrtni ishod)");

COMMIT;

-- frequency
INSERT INTO aord.frequency (value, description) VALUES (1, "retko (godišnje)");
INSERT INTO aord.frequency (value, description) VALUES (2, "ponekad (mesečno)");
INSERT INTO aord.frequency (value, description) VALUES (3, "povremeno (nedeljno)");
INSERT INTO aord.frequency (value, description) VALUES (6, "redovno (dnevno)");
INSERT INTO aord.frequency (value, description) VALUES (10, "stalno – kontinualno");

COMMIT;

-- kinney_index
INSERT INTO aord.kinney_index(value, description, probability_id, effect_id, frequency_id) VALUES (1, "veoma mali rizik – prihvatljivo", 3, 1, 2);
INSERT INTO aord.kinney_index(value, description, probability_id, effect_id, frequency_id) VALUES (40, "mali rizik - obratiti pažnju, rešiti ga redovnom procedurom", 7, 2, 2);

COMMIT;

-- mechanical_danger
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (1, "Mehaničke opasnosti (koje se pojavljuju korišćenjem opreme za rad)", "Nedovoljna bezbednost zbog rotirajućih ili pokretnih delova");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (2, "Mehaničke opasnosti (koje se pojavljuju korišćenjem opreme za rad)", "Slobodno kretanje delova ili materijala koji mogu naneti povredu zaposlenom");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (3, "Mehaničke opasnosti (koje se pojavljuju korišćenjem opreme za rad)", "Unutrašnji transport i kretanje radnih mašina ili vozila, kao i pomeranja određene opreme za rad");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (4, "Mehaničke opasnosti (koje se pojavljuju korišćenjem opreme za rad)", "Korišćenje opasnih sredstava za rad koja mogu proizvesti eksplozije ili požar");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (5, "Mehaničke opasnosti (koje se pojavljuju korišćenjem opreme za rad)", "Nemogućnost ili ograničenost pravovremenog uklanjanja sa mesta rada, izloženost zatvaranju, mehaničkom udaru, poklapanju i sl.");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (6, "Mehaničke opasnosti (koje se pojavljuju korišćenjem opreme za rad)", "Drugi faktori koji mogu da se pojave kao mehanički izvori opasnosti");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (7, "Opasnosti koji se pojavljuju u vezi sa karakteristikama radnih mesta", "Opasne površine (podovi i sve vrste gazišta, površine sa kojima zaposleni dolazi u dodir, a koje imaju oštre ivice - rubove, šiljke, grube površine, izbočene delove, i sl.)");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (8, "Opasnosti koji se pojavljuju u vezi sa karakteristikama radnih mesta", "Rad na visini ili u dubini, u smislu propisa o bezbednosti i zdravlju na radu");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (10, "Opasnosti koji se pojavljuju u vezi sa karakteristikama radnih mesta", "Mogućnost klizanja ili spoticanja (mokre ili klizave površine)");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (11, "Opasnosti koji se pojavljuju u vezi sa karakteristikama radnih mesta", "Fizička nestabilnost radnog mesta");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (12, "Opasnosti koji se pojavljuju u vezi sa karakteristikama radnih mesta", "Moguće posledice ili smetnje usled obavezne upotrebe sredstava ili opreme za ličnu zaštitu na radu");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (13, "Opasnosti koji se pojavljuju u vezi sa karakteristikama radnih mesta", "Uticaji usled obavljanja procesa rada korišćenjem neodgovarajućih ili neprilagođenih metoda rada");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (14, "Opasnosti koji se pojavljuju u vezi sa karakteristikama radnih mesta", "Druge opasnosti koje se mogu pojaviti u vezi sa karakteristikama radnog mesta i načinom rada (korišćenje sredstava i opreme za ličnu zaštitu na radu koja opterećuju zaposlenog, i sl.)");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (15, "Opasnosti koje se pojavljuju korišćenjem električne energije", "Opasnost od direktnog dodira sa delovima električne instalacije i opreme pod naponom");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (16, "Opasnosti koje se pojavljuju korišćenjem električne energije", "Opasnost od indirektnog dodira");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (17, "Opasnosti koje se pojavljuju korišćenjem električne energije", "Opasnost od toplotnog dejstva koje razvijaju električna oprema i instalacije (pregrevanje, požar, eksplozija, električni luk ili varničenje, i dr.)");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (18, "Opasnosti koje se pojavljuju korišćenjem električne energije", "Opasnosti usled udara groma i posledica atmosferskog pražnjenja");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (19, "Opasnosti koje se pojavljuju korišćenjem električne energije", "Opasnost od štetnog uticaja elektrostatičkog naelektrisanja");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (20, "Opasnosti koje se pojavljuju korišćenjem električne energije", "Druge opasnosti koje se mogu pojaviti u vezi sa korišćenjem električne energije");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (21, "Štetnosti koje nastaju ili se pojavljuju u procesu rada", "Hemijske štetnosti (udisanje, gušenje, unošenje u organizam, prodor u telo kroz kožu, i sl.), prašina, dimovi, opekotine, trovanje");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (22, "Štetnosti koje nastaju ili se pojavljuju u procesu rada", "Fizičke štetnosti buka i vibracije");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (23, "Štetnosti koje nastaju ili se pojavljuju u procesu rada", "Biološke štetnosti, infekcije, izlaganje mikroorganizmima, alergentima");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (24, "Štetnosti koje nastaju ili se pojavljuju u procesu rada", "Štetni uticaji mikroklime, visoka temperatura,niska temperatura,vlažnost vazduha,brzina strujanja vazduha");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (25, "Štetnosti koje nastaju ili se pojavljuju u procesu rada", "Neodgovarajuća - nedovoljna osvetljenost");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (26, "Štetnosti koje nastaju ili se pojavljuju u procesu rada", "Štetni uticaji zračenja,toplotnog, jonizujućeg, ultravioletnog, nejonizujućeg, laserskog, ultrazvučnog");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (27, "Štetnosti koje nastaju ili se pojavljuju u procesu rada", "Štetni klimatski uticaji, rad na otvorenom");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (28, "Štetnosti koje nastaju ili se pojavljuju u procesu rada", "Štetnosti koje nastaju korišćenjem opasnih materija u proizvodnji, transportu, pakovanju, skladištenju ili uništavanju (klase 1,2,...9)");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (29, "Štetnosti koje nastaju ili se pojavljuju u procesu rada", "Druge štetnosti koje se pojavljuju u radnom procesu, a koje mogu da budu uzrok povrede na radu zaposlenog, profesionalnog oboljena ili oboljenja u vezi sa radom.");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (30, "Štetnosti koje proističu iz psihičkih i psihofizičkih napora", "Napori ili telesna naprezanja (ručno prenošenje tereta, guranje ili vučenje tereta, razne dugotrajne povećane telesne aktivnosti)");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (31, "Štetnosti koje proističu iz psihičkih i psihofizičkih napora", "Nefiziološki položaj tela (dugotrajno stajanje, sedenje, čučanje, klečanje)");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (32, "Štetnosti koje proističu iz psihičkih i psihofizičkih napora", "Napori pri obavljanju određenih poslova koji prouzrokuju psihološka opterećenja (stres, monotonija)");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (33, "Štetnosti koje proističu iz psihičkih i psihofizičkih napora", "Odgovornost u primanju i prenošenju informacija, korišćenje odgovarajućeg znanja i sposobnosti, odgovornost u pravilima ponašanja, odgovornost za brze izmene radnih procedura, intenzitet u radu, prostorna uslovljenost radnog mesta, konfliktne situacije, rad sa strankama i novcem, nedovoljna motivacija za rad, odgovornost u rukovođenju, i sl.");
INSERT INTO aord.mechanical_danger(danger_number, danger_type, description) VALUES (34, "Štetnosti koje proističu iz psihičkih i psihofizičkih napora", "Štetnosti vezane za organizaciju rada (rad duži od punog radnog vremena-prekovremeni rad, rad u smenama, skraćeno radno vreme, rad noću, pripravnost za slučaj intervencija, i sl.)");