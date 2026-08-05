import React from 'react';
import AccountMenu from '../menu/AccountMenu';

interface IHeaderBarProps {
    onVaultDexLogoClick: () => void;
}

const HeaderBar = ({ onVaultDexLogoClick }: IHeaderBarProps) => {

    const [isAccountMenuOpen, setIsAccountMenuOpen] = React.useState(false);

    const onAccountIconClick = () => {
        setIsAccountMenuOpen(!isAccountMenuOpen);
    };

    return (
        <div className="grid">
            <div className="flex justify-between items-center">
                <div onClick={onVaultDexLogoClick} style={{ cursor: 'pointer' }}>VaultDex</div>
                <div className="relative">
                    <button
                        type="button"
                        onClick={onAccountIconClick}
                        onBlur={() => setIsAccountMenuOpen(false)}
                        className="hover:bg-gray-100 px-2 py-1 rounded"
                    >
                        Account
                    </button>
                    {isAccountMenuOpen && (
                        <div
                            className="absolute right-0 mt-2 w-40 rounded border bg-white shadow-lg"
                            onMouseDown={(event) => event.preventDefault()}
                        >
                            <AccountMenu onClose={() => setIsAccountMenuOpen(false)} />
                        </div>
                    )}
                </div>
            </div>
            <hr />
        </div>
    )
}

export default HeaderBar;