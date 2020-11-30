package io.github.rmuskovets.jom4.sprint00;

class Point_05 {
    private int x;
    private int y;

    public Point_05(int x, int y) {
        this.x = x; this.y = y;
    }

    public int[] getXYPair() {
        return new int[] { x, y };
    }

    public double distance(int x, int y) {
        return Math.hypot(this.x - x, this.y - y);
    }

    public double distance(Point_05 point) {
        return distance(point.x, point.y);
    }

    public double distance() {
        return distance(0, 0);
    }
}