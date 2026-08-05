import React from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../button/Button';

interface IAccountMenuProps {
    onClose?: () => void;
}

const AccountMenu = ({ onClose }: IAccountMenuProps) => {
    const navigate = useNavigate();

    const onLogoutClick = () => {
        localStorage.removeItem('isAuthenticated');
        onClose?.();
        navigate('/login');
    };

    return (
        <div className="flex flex-col p-2 text-sm">
            <Button className="px-2 py-1 text-left hover:bg-gray-100" label="Profile" />
            <Button className="px-2 py-1 text-left hover:bg-gray-100" label="Settings" />
            <Button className="px-2 py-1 text-left hover:bg-gray-100" label="Logout" onClick={onLogoutClick} />
        </div>
    );
};

export default AccountMenu;
