INSERT INTO thresholds (
                    substance, formula,
                    total_concentration_threshold_zero,
                    total_concentration_threshold_one,
                    total_concentration_threshold_two,
                    leachable_concentration_threshold_zero,
                    leachable_concentration_threshold_one,
                    leachable_concentration_threshold_two,
                    leachable_concentration_threshold_three )

VALUES
        -- metallic ions
        ( 'Arsenic', 'As', 5.8, 500, 2000, 0.01, 0.5, 1, 4 ),
        ( 'Boron', 'B', 150, 15000, 60000, 0.5, 25, 50, 200 ),
        ( 'Barium', 'Ba', 62.5, 6250, 25000, 0.7, 35, 70, 380 ),
        ( 'Cadmium', 'Cd', 7.5, 260, 1040, 0.003, 0.15, 0.3, 1.2 ),
        ( 'Cobalt', 'Co', 50, 5000, 20000, 0.5, 25, 50, 200 ),
        ( 'Chromium Total', 'CrTotal', 46000, 800000, 0.0, 0.1, 5, 10, 40 ),
        ( 'Chromium (VI)', 'Cr(VI)', 6.5, 500, 2000, 0.05, 2.5, 5, 20 ),
        ( 'Copper', 'Cu', 16, 19500, 78000, 2, 100, 200, 800 ),
        ( 'Mercury', 'Hg', 0.93, 160, 640, 0.006, 0.3, 0.6, 2.4 ),
        ( 'Manganese', 'Mn', 1000, 25000, 100000, 0.5, 25, 50, 200 ),
        ( 'Molybdenum', 'Mo', 40, 1000, 4000, 0.07, 3.5, 7, 28 ),
        ( 'Nickel', 'Ni', 91, 10600, 42400, 0.07, 3.5, 7, 28 ),
        ( 'Lead', 'Pb', 20, 1900, 7600, 0.01, 0.5, 1, 4 ),
        ( 'Antimony', 'Sb', 10, 75, 300, 0.02, 1, 2, 8 ),
        ( 'Selenium', 'Se', 10, 50, 200, 0.01, 0.5, 1, 4 ),
        ( 'Vanadium', 'V', 150, 2680, 10720, 0.2, 10, 20, 80 ),
        ( 'Zinc', 'Zn', 240, 160000, 640000, 5, 250, 500, 2000 ),

        -- inorganic anions */
        ( 'Total Dissolved Solids', 'TDS', 0.0, 0.0, 0.0, 1000, 12500, 25000, 100000 ),
        ( 'Chloride', 'Cl', 0.0, 0.0, 0.0, 300, 15000, 30000, 120000 ),
        ( 'Sulphate', 'SO4', 0.0, 0.0, 0.0, 250, 12500, 25000, 100000 ),
        ( 'Nitrate-N', 'NO3N', 0.0, 0.0, 0.0, 11, 550, 1100, 4400 ),
        ( 'Fluoride', 'F', 100, 10000, 40000, 1.5, 75, 150, 600 ),
        ( 'Cyanide Total', 'CN (total)', 14, 10500, 42000, 0.07, 3.5, 7, 28 ),

        -- organics */
        ( 'Benzene', 'C6H6', 0.0, 10, 40, 0.0, 3.5, 7, 28 ),
        ( 'Benzo(a)pyrene', 'C20H12', 0.0, 1.7, 6.8, 0.0, 0.035, 0.07, 0.28 ),
        ( 'Carbon tetrachloride', 'CCl4', 0.0, 4, 16, 0.0, 0.2, 0.4, 1.6 ),
        ( 'Chlrobenzene', 'C6H5Cl', 0.0, 8800, 35200, 0.0, 5, 10, 4 ),
        ( 'Chloroform', 'CHCl3', 0.0, 700, 2800, 0.0, 15, 30, 120 ),
        ( '2-Chlorophenol', 'C6H5ClO', 0.0, 2100, 8400, 0.0, 15, 30, 120 ),
        ( 'Di (2 ethylhexyl) phthalate', 'C24H38O4', 0.0, 40, 160, 0.0, 0.5, 1, 4 ),
        ( '1,2-Dichlorobenzene', 'C6H4Cl2', 0.0, 31900, 127600, 0.0, 5, 10, 40 ),
        ( '1,4-Dichlorobenzene', 'C6H4Cl2', 0.0, 18400, 73600, 0.0, 15, 30, 120 ),
        ( '1,2-Dichloroethane', 'C2H4Cl2', 0.0, 3.7, 14.8, 0.0, 1.5, 3, 12 ),
        ( '1,1-Dichloroethylene', 'C2H2Cl2', 0.0, 150, 600, 0.0, 0.35, 0.7, 2.8 ),
        ( '1,2-Dichloroethylene', 'C2H2Cl2', 0.0, 3750, 1500, 0.0, 2.5, 5, 20 ),
        ( 'Dichlormethane', 'CH2Cl2', 0.0, 16, 64, 0.0, 0.25, 0.5, 2 ),
        ( '2,4-Dichlorophenol', 'C6H4Cl2O', 0.0, 800, 32000, 0.0, 10, 20, 80 ),
        ( '2,4-Dinitrotoluene', 'C7H6N2O4', 0.0, 5.2, 20.8, 0.0, 0.065, 0.13, 0.52 ),
        ( 'Ethylbenzene', 'C8H10', 0.0, 540, 2160, 0.0, 3.5, 7, 28 ),
        ( 'Formaldehyde', 'CH2O', 0.0, 2000, 8000, 0.0, 25, 50, 200 ),
        ( 'Hexachlorobutadiene', 'C4Cl6', 0.0, 2.8, 5.4, 0.0, 0.03, 0.06, 0.24 ),
        ( 'Methyl ethyl ketone', 'C4H8O', 0.0, 8000, 32000, 0.0, 100, 200, 800 ),
        ( 'Methyl t-butyl ether (MTBE)', '(CH3)3COCH3', 0.0, 1435, 5740, 0.0, 2.5, 5, 20 ),
        ( 'Nitrobenzene', 'C6H5NO2', 0.0, 45, 180, 0.0, 1, 2, 8 ),
        ( 'Polycyclic aromatic hydrocarbons (total)', 'PAHs', 0.0, 50, 200, 0.0, 0.0, 0.0, 0.0 ),
        ( 'Petroleum', 'C6 to C9', 0.0, 650, 2600, 0.0, 0.0, 0.0, 0.0 ),
        ( 'Petroleum', 'C10 to C36', 0.0, 10000, 40000, 0.0, 0.0, 0.0, 0.0 ),
        ( 'Phenols (total, non-halogenated)', 'C6H5OH', 0.0, 560, 2240, 0.0, 7, 14, 56 ),
        ( 'Polychlorinated biphenyls', 'C12H10-nCln', 0.0, 12, 48, 0.0, 0.025, 0.05, 0.2 ),
        ( 'Styrene', 'C8H8', 0.0, 120, 480, 0.0, 1, 2, 8 ),
        ( '1,1,1,2-Tetrachloraethane', 'C2H2Cl4', 0.0, 400, 1600, 0.0, 5, 10, 40 ),
        ( '1,1,2,2-Tetrachloraethane', 'C2H2Cl4', 0.0, 5, 20, 0.0, 0.65, 1.3, 5.3 ),
        ( 'Tetracholorethylene', 'C2Cl4', 0.0, 200, 800, 0.0, 0.25, 0.5, 2 ),
        ( 'Toluene', 'C6H5CH3', 0.0, 1150, 4600, 0.0, 35, 70, 280 ),
        ( 'Trichlorobenzene (total)', 'C6H3Cl3', 0.0, 3300, 13200, 0.0, 3.5, 7, 28 ),
        ( '1,1,1-Trichloroethylene', 'CCl3CH3', 0.0, 1200, 4800, 0.0, 15, 30, 120 ),
        ( '1,1,2-Trichloroethylene', 'C2H3Cl3', 0.0, 48, 192, 0.0, 0.6, 1, 4 ),
        ( 'Trichloroethylene', 'C2HCl3', 0.0, 11600, 46400, 0.0, 0.25, 2, 8 ),
        ( '2,4,6-Trichlorophenol', 'C6H2Cl3OH', 0.0, 1.5, 6, 0.0, 10, 20, 80 ),
        ( 'Vynil chloride', 'C2H3Cl', 0.0, 1.5, 6, 0.0, 0.015, 0.03, 0.12 ),
        ( 'Xylenes (total)', '(CH3)2C6H4', 0.0, 890, 3560, 0.0, 25, 50, 200 ),

        -- pesticides */
        ( 'Adrin + Dieldrin', 'C12H8Cl6 + C12H8Cl6O', 0.05, 1.2, 4.8, 0.0, 0.015, 0.03, 0.03 ),
        ( 'Dichlorodiphenyltrichloroethane + Dichlorodiphenyldichloroethane + Dichlorodiphenyldichloroethylene', 'C14H9Cl5 + C14H10Cl4 + C14H8Cl4', 0.05, 50, 200, 0.0, 1, 2, 2 ),
        ( '2,4-Dichlorophenoxyacetic', 'C8H6Cl2O3', 0.05, 120, 480, 0.0, 1.5, 3, 3 ),
        ( 'Chlordane', 'C10H6Cl8', 0.05, 4, 16, 0.0, 0.05, 0.1, 0.1 ),
        ( 'Heptachlor', 'C10H5Cl7', 0.05, 1.2, 4.8, 0.0, 0.015, 0.03, 0.03 )
;

INSERT INTO categories ( name, description )

VALUES
        ( 'Type 0', '(LC > LCT3 or TC > TCT2) | ' ||
                    'where LCT3 is Leachable Concentration Threshold 3 ' ||
                    'and TCT2 is Total Concentration Threshold 2 ' ||
                    'are Type 0 Wastes'),
        ( 'Type 1', '(LCT2 < LC <= LCT3 or TCT1 < TC <= TCT2) | ' ||
                    'where LCT2 is Leachable Concentration Threshold 2 ' ||
                    'and LCT3 is Leachable Concentration Threshold 3 ' ||
                    'and LCT1 is Leachable Concentration Threshold 1 ' ||
                    'and TCT2 is Total Concentration Threshold 2 ' ||
                    'are Type 1 Wastes' ),
        ( 'Type 2', '(LCT1 < LC <= LCT2 or TC <= TCT1) | ' ||
                    'where LCT1 is Leachable Concentration Threshold 1 ' ||
                    'and LCT2 is Leachable Concentration Threshold 2 ' ||
                    'and TCT2 is Total Concentration Threshold 2 ' ||
                    'are Type 2 Wastes' ),
        ( 'Type 3', '(LCT0 < LC <= LCT1 or TC <= TCT1) | ' ||
                    'where LCT0 is Leachable Concentration Threshold 0 ' ||
                    'and LCT1 is Leachable Concentration Threshold 1 ' ||
                    'and TCT1 is Total Concentration Threshold 1 ' ||
                    'are Type 3 Wastes' ),
        ( 'Type 4', '(LC <= LCT0 or TC <= TCT0) | ' ||
                    'where LCT0 is Leachable Concentration Threshold 0 ' ||
                    'and TCT0 is Total Concentration Threshold 0 ' ||
                    'and less than or equal in mg/kg, ' ||
                    'TOC=30 000, BTEX=6, PCBs=1, Mineral Oil (C10 to C40)=500 ' ||
                    'and all pesticides=0.05 ' ||
                    'are Type 4 Wastes' )
;
