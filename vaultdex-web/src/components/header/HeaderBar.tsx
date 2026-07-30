import React from 'react';
import NavBar from '../navigation/NavBar';

const HeaderBar = () => {

    return (
        <div className="grid">
            <div className="flex justify-between">
                <div>VaultDex</div>
                <NavBar />
                <div>account icon</div>
            </div>
            <hr />
        </div>

    )
}

export default HeaderBar;