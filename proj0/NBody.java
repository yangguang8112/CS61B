public class NBody {
    public static String backimg = "images/starfield.jpg";

    public static double readRadius(String file_path) {
        In input = new In(file_path);
        int planet_num = input.readInt();
        return input.readDouble();
    }

    public static Planet[] readPlanets(String file_path) {
        In input = new In(file_path);
        int planet_num = input.readInt();
        double radius = input.readDouble();
        Planet[] planets = new Planet[planet_num];
        for (int i=0; i < planet_num; i ++) {
            planets[i] = new Planet(
                input.readDouble(),
                input.readDouble(),
                input.readDouble(),
                input.readDouble(),
                input.readDouble(),
                input.readString()
            );
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        int planets_num = planets.length;
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.enableDoubleBuffering();
        StdDraw.picture(0, 0, backimg);
        for (int i = 0; i < planets_num; i ++) {
            planets[i].draw();
        }
        StdDraw.show();
        for (double universe_time = 0; universe_time < T; universe_time += dt) {
            StdDraw.clear();
            StdDraw.picture(0, 0, backimg);
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets_num; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets_num; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        System.out.println(planets_num);
        System.out.println(radius);
        String blank = " ";
        for (int i = 0; i < planets_num; i ++) {
            System.out.println(planets[i].xxPos + blank + planets[i].yyPos + blank + planets[i].xxVel + blank + planets[i].yyVel + blank + planets[i].mass + blank + planets[i].imgFileName);
        }
    }
}
