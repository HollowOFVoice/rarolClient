package educationalpractice.placecarclient.Controller;

import educationalpractice.placecarclient.Entity.PM;
import lombok.Data;

@Data
public class ParkingSpot extends PM {
        private int number;
        private int A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S;

    public ParkingSpot(int i) {
        this.number = i;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
    }

}
