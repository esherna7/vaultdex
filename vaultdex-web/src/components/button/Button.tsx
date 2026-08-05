import React from 'react';

interface IButtonProps {
    label: string;
    onClick?: () => void;
}

const Button = ({ label, onClick, className }: IButtonProps & { className?: string }) => {
    return (
        <button
            type="button"
            onClick={onClick}
            className={className}
        >
            {label}
        </button>
    );
};

export default Button;