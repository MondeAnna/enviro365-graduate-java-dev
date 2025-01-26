INSERT INTO waste_categories ( name, description )

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

INSERT INTO disposal_guidelines
    ( classification, waste_category, description, landfill )

VALUES
    ( 'A', 'Type 1', 'High risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'Hh/HH' ),
    ( 'B', 'Type 2', 'Moderate risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'GLB+' ),
    ( 'C', 'Type 3', 'Low risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'GLB+' ),
    ( 'D', 'Type 4', 'Inert waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'GLB-' ),

    ( 'B', 'domestic waste', 'Moderate risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'GLB+' ),
    ( 'B', 'business waste with hazardous substances', 'Moderate risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'GLB+' ),
    ( 'B', 'non-infectious animal carcasses', 'Moderate risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'GLB+' ),
    ( 'B', 'garden waste', 'Moderate risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'GLB+' ),

    ( 'C', 'post-consumer packaging', 'Low risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'GLB+' ),
    ( 'C', 'waste tyres', 'Low risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'GLB+' ),

    ( 'D', 'business waste without hazardous substances', 'Inert waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'GLB-' ),
    ( 'D', 'excavated earth material without hazardous substances', 'Inert waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'GLB-' ),

    ( 'A', 'asbestos waste', 'High risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'Hh/hh' ),
    ( 'A', 'expired, spoilt or unusable hazardous products', 'High risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'Hh/HH' ),
    ( 'A', 'PCBs containing was (>50 ppm)', 'High risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'Hh/hh' ),
    ( 'A', 'general waste, excluding domestic waste, containing hazardous substances', 'High risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'Hh/hh' ),
    ( 'A', 'mixed hazardous substances from analytics laboratories and academic institution libraries in containers less than 100 litres', 'High risk waste as defined in the document Minimum Requirements for Waste Disposal by Landfill (2nd Ed., DWAF, 1998)', 'Hh/hh' )
;

INSERT INTO recycling_tips ( tip, description )

VALUES
    ( 'Refuse', 'You’ll have to minimize the waste production by refusing to use non-recyclable products. The logistics of it can look intimidating at first, but there are better and far-less wasteful materials that you can switch over to.' ),
    ( 'Reduce', 'The reduction of harmful, wasteful, and non-recyclable materials to save more money, and reduce the total amount in landfills.' ),
    ( 'Reuse', 'Single-use plastics have created a "throw-away" culture by normalizing consumer behavior of using materials once and then throwing them away, which needs conscious effect to act against.' ),
    ( 'Repurpose', 'The idea of repurposing involves taking items that were meant for one purpose but can be used for other ones.' ),
    ( 'Recycle', 'After quality effort going through Refuse, Reduce, Reuse, and Repurpose, recycling is a great final option.' ),
    ( 'Sort Your Rubbish', 'Be sure to sort your waste into paper, glass, plastic, metal and biodegradable food waste.' ),
    ( 'Assist With Transportation', 'There are numerous drop-off facilities that exist that you can drive your recyclables to. Use different bins to store your recyclables in until you are ready to make a mass drop-off.' ),
    ( 'Clean Recyclables', 'Before your materials into different bags be sure to rinse off any leftover food or waste to clean it off.' ),
    ( 'Recycle Plastic', 'Plastic is made from oil, a non-renewable resource, which is why it is so important to recycle plastic.' ),
    ( 'Compost Food Waste', 'Saved vegetable and fruit peels can be used to create homemade compost for use in food gardens or flowers and shrubs.' ),
    ( 'Reuse Water', 'Water from baths, showers and such may be reused to water gardens, flowers and shrubs.' ),
    ( 'Donate Unused Goods', 'Pack unused items and donate them to a local charity or secondhand store. This reduces the waste in landfills, lessen the unnecessary production of products and also free up some space in your cupboards.' ),
    ( 'Discarding Glass', 'Do not put drinking glasses, cups or dishware in the recycling bin. This causes issues for the processors. If you have dishware and drinking glasses that are intact, donate them. If they are broken, put them in the trash and send them to the landfill.' ),
    ( 'Compostable Plastics', 'Compostable plastics are only compostable in industrial or commercial compost processing facilities and have specifically marked bins marked. When purchasing, ensure products are marked as "compostable" and ideally display the BPI certified logo.' ),
    ( 'Batteries', 'Take used batteries to a recycling facility or store that recycles batteries.' ),
    ( 'Electronics', 'Take electronics to a SERI certified electronics recycling facility.' ),
    ( 'Bring Your Own', 'This is a sustainable hack whereby one brings and uses ones own re-usable items.' ),
    ( 'Buy Recycled', 'Supporting recycling means feeding this loop by not only recycling, but also supporting recycled products.' )
;