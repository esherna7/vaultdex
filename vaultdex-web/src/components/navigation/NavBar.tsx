import React from 'react';

const NavBar = () => {

    const activeTab = 'home';
    
    return (
        <nav>
            <a className={activeTab === 'home' ? 'font-bold underline' : ''}>Home</a>
            <a className={activeTab === 'sets' ? 'font-bold' : ''}>Sets</a>
            <a className={activeTab === 'collection' ? 'font-bold' : ''}>My Collection</a>
        </nav>
    )
}

export default NavBar;