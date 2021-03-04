package com.example.tapordie;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> Updated Gravity and tap amount.

import java.util.ArrayList;

public class Chopper extends BaseObject {
    private ArrayList<Bitmap> arrBms = new ArrayList<>();
    private int count, vFlap, idCurrentBitmap;
    private float drop;
    private int monkeyNums = 0;
<<<<<<< HEAD
    private int yMove = 0;
    private double speed = 5;
    private int moveTo = 0;
    private ChopperState state = ChopperState.NOTMOVING;

    public Chopper(){
        this.count = 0;
        this.vFlap =0;
=======

    public Chopper(){
        this.count = 0;
        this.vFlap =5;
>>>>>>> Updated Gravity and tap amount.
        this.idCurrentBitmap = 0;
        this.drop = 0;
    }
    public void draw(Canvas canvas) {
<<<<<<< HEAD
        canvas.drawBitmap(this.getBm(), this.x, this.y, null);
    }

    public void update() {
        switch(this.state) {
            case MOVINGUP:
                this.y += this.speed;
                if(this.y > this.moveTo) {this.state=ChopperState.NOTMOVING;}
                break;
            case MOVINGDOWN:
                this.y -= this.speed;
                if(this.y < this.moveTo) {this.state=ChopperState.NOTMOVING;}
                break;
            default:
                break;
        }
        Log.d("state", this.state.toString());
    }

    private void drop() {
//        this.drop += 0.6;
//        this.drop += (monkeyNums)*0.3;
//        this.drop += 0.1;
//        this.drop = 0;
//        this.y += this.drop;
=======
        drop();
        canvas.drawBitmap(this.getBm(), this.x, this.y, null);
    }

    private void drop() {
//        this.drop += 0.6;
        this.drop += (monkeyNums)*0.3;
        this.drop += 0.1;
//        this.drop += 0;
        this.y += this.drop;
>>>>>>> Updated Gravity and tap amount.
    }

    public float getDrop() {
        return drop;
    }

    public void setDrop(float drop) {
        this.drop = drop;
    }

    public ArrayList<Bitmap> getArrBms() {
        return arrBms;
    }

    public void setArrBms(ArrayList<Bitmap> arrBms) {
        this.arrBms = arrBms;
        //scale bitmaps to size of Chopper
        for(int i = 0; i < arrBms.size(); i++){
<<<<<<< HEAD
            this.arrBms.set(i, Bitmap.createScaledBitmap(this.arrBms.get(i), this.width*2, this.height*2, true));
=======
            this.arrBms.set(i, Bitmap.createScaledBitmap(this.arrBms.get(i), this.width, this.height, true));
>>>>>>> Updated Gravity and tap amount.
        }
    }

    @Override
    public Bitmap getBm() {
        count++;
        if(this.count == this.vFlap){
            for(int i = 0; i <arrBms.size(); i++){
                if(i == arrBms.size()-1) {
                    this.idCurrentBitmap = 0;
                    break;
                } else if (this.idCurrentBitmap == i) {
                    idCurrentBitmap = i + 1;
                    break;
                }
            }
            count =0;
        }
<<<<<<< HEAD
        Matrix matrix = new Matrix();
        if(state == ChopperState.MOVINGDOWN) {
            if (this.y - this.moveTo < 70) {
//                matrix.postRotate((float) (-45 + (.1* this.moveTo-this.y)));
                matrix.postRotate(-25);
            } else {
                matrix.postRotate(-25);
            }
         } else if(state == ChopperState.MOVINGUP) {
            if (this.moveTo - this.y < 70) {
//                matrix.postRotate((float) -.1* this.y-this.moveTo);
                matrix.postRotate(25);
            } else {
                matrix.postRotate(25);
            }
        } else {
            matrix.postRotate(10);
        }
            return Bitmap.createBitmap(arrBms.get(idCurrentBitmap), 0, 0, arrBms.get(idCurrentBitmap).getWidth(), arrBms.get(idCurrentBitmap).getHeight(), matrix, true);
//        return this.arrBms.get(idCurrentBitmap);
    }

    public int getMoveTo() {
        return this.moveTo;
    }
    public void setMoveTo(int yTarget) {
        this.moveTo = yTarget;
    }

    public void setState(ChopperState newState) {
        this.state = newState;
    }

    public ChopperState getState() {
       return this.state;
    }

    public void directionCheck(float y) {
        this.moveTo = (int)y;
        if(y > this.y) {
            this.state = ChopperState.MOVINGUP;
        }
        else if(y < this.y) {
            this.state = ChopperState.MOVINGDOWN;
        } else {
            this.state = ChopperState.NOTMOVING;
        }
=======
        if(this.drop<0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(-25);
            return Bitmap.createBitmap(arrBms.get(idCurrentBitmap), 0, 0, arrBms.get(idCurrentBitmap).getWidth(), arrBms.get(idCurrentBitmap).getHeight(), matrix, true);
        } else if(drop>=0){
            Matrix matrix = new Matrix();
            if(drop<70) {
                matrix.postRotate(-25+(drop*2));
            } else {
                matrix.postRotate(45);
            }
            return Bitmap.createBitmap(arrBms.get(idCurrentBitmap), 0, 0, arrBms.get(idCurrentBitmap).getWidth(), arrBms.get(idCurrentBitmap).getHeight(), matrix, true);
        }
        return this.arrBms.get(idCurrentBitmap);
>>>>>>> Updated Gravity and tap amount.
    }
}
