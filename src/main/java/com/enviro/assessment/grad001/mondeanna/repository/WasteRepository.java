package com.enviro.assessment.grad001.mondeanna.repository;

import com.enviro.assessment.grad001.mondeanna.model.Waste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteRepository extends JpaRepository<Waste, String> {

//    private final Set<Waste> repository = createRepository();
//
//    public Set<Waste> findAll(){
//        return repository;
//    }
//
//    public Waste findById( String formula ){
//        return findAll().stream()
//            .filter( waste -> waste.formula().equals( formula ))
//            .findFirst()
//            .orElseThrow(() -> new IllegalArgumentException( "Waste not found" ));
//    }
//
//    private Set<Waste> createRepository(){
//        return Set.of(
//            /* metallic ions */
//            new Waste( "Arsenic", "As", 5.8, 500, 2_000, 0.01, 0.5, 1, 4 ),
//            new Waste( "Boron", "B", 150, 15_000, 60_000, 0.5, 25, 50, 200 ),
//            new Waste( "Barium", "Ba", 62.5, 6_250, 25_000, 0.7, 35, 70, 380 ),
//            new Waste( "Cadmium", "Cd", 7.5, 260, 1_040, 0.003, 0.15, 0.3, 1.2 ),
//            new Waste( "Cobalt", "Co", 50, 5_000, 20_000, 0.5, 25, 50, 200 ),
//            new Waste( "Chromium Total", "CrTotal", 46_000, 800_000, 0, 0.1, 5, 10, 40 ),
//            new Waste( "Chromium (VI)", "Cr(VI)", 6.5, 500, 2_000, 0.05, 2.5, 5, 20 ),
//            new Waste( "Copper", "Cu", 16, 19_500, 78_000, 2, 100, 200, 800 ),
//            new Waste( "Mercury", "Hg", 0.93, 160, 640, 0.006, 0.3, 0.6, 2.4 ),
//            new Waste( "Manganese", "Mn", 1_000, 25_000, 100_000, 0.5, 25, 50, 200 ),
//            new Waste( "Molybdenum", "Hg", 40, 1_000, 4_000, 0.07, 3.5, 7, 28 ),
//            new Waste( "Nickel", "Ni", 91, 10_600, 42_400, 0.07, 3.5, 7, 28 ),
//            new Waste( "Lead", "Pb", 20, 1_900, 7_600, 0.01, 0.5, 1, 4 ),
//            new Waste( "Antimony", "Sb", 10, 75, 300, 0.02, 1, 2, 8 ),
//            new Waste( "Selenium", "Se", 10, 50, 200, 0.01, 0.5, 1, 4 ),
//            new Waste( "Vanadium", "V", 150, 2_680, 10_720, 0.2, 10, 20, 80 ),
//            new Waste( "Zinc", "Zn", 240, 160_000, 640_000, 5, 250, 500, 2_000 ),
//
//            /* inorganic anions */
//
//            /* organics */
//            new Waste( "Trichlorobenzene", "C6H3Cl3", 0.0, 3_300, 13_200, 0, 3.5, 7, 28 ),
//            new Waste( "1,1,1-Trichloroethylene", "CCl3CH3", 0.0, 1_200, 4_800, 0, 15, 30, 120 ),
//            new Waste( "1,1,2-Trichloroethylene", "C2H3Cl3", 0.0, 48, 192, 0, 0.6, 1, 4 ),
//            new Waste( "Trichloroethylene", "C2HCl3", 0.0, 11_600, 46_400, 0, 0.25, 2, 8 ),
//            new Waste( "2,4,6-Trichlorophenol", "C6H2Cl3OH", 0.0, 1.5, 6, 0, 10, 20, 80 ),
//            new Waste( "Vynil chloride", "(CH3)2C6H4", 0.0, 1.5, 6, 0, 0.015, 0.03, 0.12 ),
//            new Waste( "Xylenes", "(CH3)2C6H4", 0.0, 890, 3_560, 0, 25, 50, 200 ),
//
//            /* pesticides */
//            // summative of Aldrin and Dieldrin skipped
//            // summative of DDT, DDD, and DDE skipped
//
//            new Waste( "2,4-Dichlorophenoxyacetic", "C8H6Cl2O3", 0.05, 120, 480, 0, 1.5, 3, 3 ),
//            new Waste( "Chlordane", "C10H6Cl8", 0.05, 4, 16, 0, 0.05, 0.1, 0.1 ),
//            new Waste( "Heptachlor", "C10H5Cl7", 0.05, 1.2, 4.8, 0, 0.015, 0.03, 0.03 )
//        );
//    }
}
