public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    public static double changshu_G = 6.67E-11;
    
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.pow((Math.pow((this.xxPos - p.xxPos), 2) + Math.pow((this.yyPos - p.yyPos), 2)), 0.5);
    }

    public double calcForceExertedBy(Planet p) {
        double r = this.calcDistance(p);
        // String lianjie = "   ";
        // System.out.println(Planet.changshu_G + lianjie + this.mass  + lianjie +  p.mass + lianjie + r);
        double F = Planet.changshu_G * this.mass * p.mass / Math.pow(r, 2);
        return F;
    }

    public double calcForceExertedByX(Planet p) {
        double r = this.calcDistance(p);
        double F = this.calcForceExertedBy(p);
        return F * (p.xxPos - this.xxPos) / r;
    }

    public double calcForceExertedByY(Planet p) {
        double r = this.calcDistance(p);
        double F = this.calcForceExertedBy(p);
        return F * (p.yyPos - this.yyPos) / r;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double ans = 0.0;
        for (Planet p : allPlanets) {
            if (this.equals(p)) {
                continue;
            }
            ans += this.calcForceExertedByX(p);
        }
        return ans;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double ans = 0.0;
        for (Planet p : allPlanets) {
            if (this.equals(p)) {
                continue;
            }
            ans += this.calcForceExertedByY(p);
        }
        return ans;
    }

    public void update(double dt, double fX, double fY) {
        this.xxVel += fX / this.mass * dt;
        this.yyVel += fY / this.mass * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }

}
