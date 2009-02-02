/*
Copyright (c) 2008~2009, Justin R. Bengtson (poopshotgun@yahoo.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
        this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
        this list of conditions and the following disclaimer in the
        documentation and/or other materials provided with the distribution.
    * Neither the name of Justin R. Bengtson nor the names of contributors may
        be used to endorse or promote products derived from this software
        without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package ssw.states;

import ssw.Constants;
import ssw.components.*;

public class stChassisCLECQD implements ifChassis, ifState {
    // A Clan Endo-Composite Biped chassis
    private final static float[] Masses = { 1.0f, 1.5f, 1.5f, 2.0f, 2.5f, 3.0f,
        3.0f, 3.5f, 4.0f, 4.5f, 4.5f, 5.0f, 5.5f, 6.0f, 6.0f, 6.5f, 7.0f, 7.5f,
        7.5f };
    private final static int[][] IntPoints = {
        { 4, 3, 1, 2 },
        { 5, 4, 2, 3 },
        { 6, 5, 3, 4 },
        { 8, 6, 4, 6 },
        { 10, 7, 5, 7 },
        { 11, 8, 6, 8 },
        { 12, 10, 6, 10 },
        { 14, 11, 7, 11 },
        { 16, 12, 8, 12 },
        { 18, 13, 9, 13 },
        { 20, 14, 10, 14 },
        { 21, 15, 10, 15 },
        { 22, 15, 11, 15 },
        { 23, 16, 12, 16 },
        { 25, 17, 13, 17 },
        { 27, 18, 14, 18 },
        { 29, 19, 15, 19 },
        { 30, 20, 16, 20 },
        { 31, 21, 17, 21 } };
    private final static AvailableCode AC = new AvailableCode( true, 'E', 'X',
            'X', 'F', 3073, 0, 0, "CWX", "", false, false, 3071, true, "CWX",
            Constants.EXPERIMENTAL, Constants.UNALLOWED );

    public boolean IsClan() {
        return AC.IsClan();
    }

    public int GetCrits() {
        return 4;
    }
    
    public String GetLookupName() {
        return "Endo-Composite";
    }

    public String GetCritName() {
        return "Endo-Composite";
    }

    public String GetMMName() {
        return "Endo-Composite";
    }

    public float GetStrucTon( int Tonnage ) {
        return Masses[GetIndex( Tonnage )];
    }
    
    public boolean IsQuad() {
        return true;
    }
    
    public int GetHeadPoints() {
        // All mech heads have 3 internal structure points
        return 3;
    }

    public int GetCTPoints( int Tonnage ) {
        return IntPoints[GetIndex(Tonnage)][0];
    }

    public int GetSidePoints( int Tonnage ) {
        return IntPoints[GetIndex(Tonnage)][1];
    }
    
    public int GetArmPoints( int Tonnage ) {
        // Quads have legs for "arms" so we return the leg points
        return IntPoints[GetIndex(Tonnage)][3];
    }

    public int GetLegPoints( int Tonnage ) {
        return IntPoints[GetIndex(Tonnage)][3];
    }

    public float GetCost( int Tonnage ) {
        return 3200 * Tonnage;
    }
    
    public float GetBVMult() {
        return 1.0f;
    }

    public boolean IncrementPlaced() {
        return true;
    }

    public boolean DecrementPlaced() {
        return true;
    }

    public AvailableCode GetAvailability() {
        return AC;
    }

    private int GetIndex( int Tonnage ) {
        return Tonnage / 5 - 2;
    }

    public MechModifier GetMechModifier() {
        return null;
    }

    // toString
    @Override
    public String toString() {
        return "Endo Composite";
    }
}
